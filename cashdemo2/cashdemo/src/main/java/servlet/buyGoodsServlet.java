package servlet;

import com.sun.corba.se.spi.orb.ORBData;
import common.OrderStatus;
import entity.Goods;
import entity.Order;
import entity.OrderItem;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/buyGoodsServlet")
public class buyGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("buyGoodsServlet-doGet");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("buyGoodsServlet-doPost");
        HttpSession session = req.getSession();
        session.getAttribute("order");
        List<Goods> goodslist = (List<Goods>)session.getAttribute("goodslist");
        Order order = (Order)session.getAttribute("order");
        Date t = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setFinish_time(df.format(t));
        order.setOrderStatus(OrderStatus.OK);

        //提交订单
        boolean effect = this.commitOrder(order);
        if(effect){
            for(Goods goods : goodslist){
                boolean isupdate = updateAfterBuy(goods,goods.getBuyGoodsNum());
                if(isupdate){
                    System.out.println("更新库存成功！");
                }else {
                    System.out.println("更新库存失败");
                }

            }
            resp.sendRedirect("buyGoodsSuccess.html");
        }

    }

    public boolean updateAfterBuy(Goods goods,int goodsBuyNum){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean effect=false;
        try{
            String sql ="update goods set stock=? where id = ?";
            connection = DBUtil.getConnection(true);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goods.getStock()-goodsBuyNum);
            preparedStatement.setInt(2,goods.getId());
            if(preparedStatement.executeUpdate()==1){
                effect=true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return effect;
    }


    private boolean commitOrder(Order order){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            String insertOrder="insert into `order` (id,account_id,create_time,finish_time, "+
                     "actual_amount, total_money, order_status, account_name)" +
                    " values (?,?,now(),now(),?,?,?,?)";
            String insertOrderItem="insert into order_item" +
                    "(order_id,goods_id,goods_name,goods_introduce," +
                    "goods_num,goods_unit,goods_price,goods_discount) " +
                    "values (?,?,?,?,?,?,?,?)";
            connection= DBUtil.getConnection(false);
            preparedStatement = connection.prepareStatement(insertOrder);
            preparedStatement.setString(1,order.getId());
            preparedStatement.setInt(2,order.getAccount_id());
            preparedStatement.setInt(3,order.getActual_amountInt());
            preparedStatement.setInt(4,order.getTotal_moneyInt());
            preparedStatement.setInt(5,order.getOrderStatus().getFlg());
            preparedStatement.setString(6,order.getAccount_name());

            if(preparedStatement.executeUpdate()==0){
                throw new RuntimeException("插入订单失败");
            }
            //插入订单成功
            else{
                preparedStatement = connection.prepareStatement(insertOrderItem);
                for(OrderItem orderItem : order.orderItemList){
                    preparedStatement.setString(1,order.getId());
                    preparedStatement.setInt(2,orderItem.getGoodsId());
                    preparedStatement.setString(3,orderItem.getGoodsName());
                    preparedStatement.setString(4,orderItem.getGoodsIntroduce());
                    preparedStatement.setInt(5,orderItem.getGoodsNum());
                    preparedStatement.setString(6,orderItem.getGoodsUnit());
                    preparedStatement.setInt(7,orderItem.getGoodsPriceInt());
                    preparedStatement.setInt(8,orderItem.getGoodsDiscount());
                    //将每一项preparedStatement缓存
                    preparedStatement.addBatch();
                }
                int[] effects = preparedStatement.executeBatch();
                for(int i:effects){
                    if(i==0){
                        throw new RuntimeException("插入订单项失败");
                    }
                }
                //手动进行提交
                connection.commit();

            }
        }catch(Exception e){
            e.printStackTrace();
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        }finally {
            DBUtil.close((com.mysql.jdbc.Connection) connection,preparedStatement,null);
        }
        return true;

    }
}
