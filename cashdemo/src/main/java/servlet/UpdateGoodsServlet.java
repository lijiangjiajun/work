package servlet;

import entity.Goods;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/updategoods")
public class UpdateGoodsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");


        String goodsIdString = req.getParameter("goodsID");
        int goodsId = Integer.parseInt(goodsIdString);
        String name = req.getParameter("name");
        String stock = req.getParameter("stock");
        String introduce = req.getParameter("introduce");
        String unit = req.getParameter("unit");
        String price = req.getParameter("price");
        double doublePrice = Double.valueOf(price);//把String类型变成小数
        int realPrice = new Double(doublePrice * 100).intValue();
        String discount = req.getParameter("discount");
//  1.查看当前的goosId是否存在
        Goods goods = this.getGoods(goodsId);
        if(goods==null){
            System.out.println("没有该商品");
            resp.sendRedirect("index.html");
        }
        //2.检查完成之后，如果存在Id才能删除
        else{
            goods.setName(name);
            goods.setIntroduce(introduce);
            goods.setStock(Integer.parseInt(stock));
            goods.setUnit(unit);
            goods.setPrice(Integer.parseInt(price));
            goods.setDiscount(Integer.parseInt(discount));
            boolean effect = this.modifyGoods(goods);
            if(effect){
                System.out.println("更新成功");
                resp.sendRedirect("goodsbrowse.html");
            }else{
                System.out.println("更新失败");
                resp.sendRedirect("index.html");
            }

        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;


    }

    private boolean modifyGoods(Goods goods){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean effect=false;
        try{
            String sql = "update goods set name=?,introduce=?,stock=?,unit=?,price=?,discount=? where id = ?";
            connection= DBUtil.getConnection(true);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,goods.getName());
            preparedStatement.setString(2,goods.getIntroduce());
            preparedStatement.setInt(3,goods.getStock());
            preparedStatement.setString(4,goods.getUnit());
            preparedStatement.setInt(5,goods.getPrice());
            preparedStatement.setInt(6,goods.getDiscount());
            preparedStatement.setInt(7,goods.getId());
            effect = (preparedStatement.executeUpdate()==1);
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close((com.mysql.jdbc.Connection) connection,preparedStatement,null);
        }
        return effect;
    }


    private Goods getGoods(int goodsId){
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Goods goods=null;
        try{
            String sql="select * from goods where id = ?";
            connection = DBUtil.getConnection(true);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goodsId);
            resultSet =  preparedStatement.executeQuery();
            if(resultSet.next()){
                 goods = this.extractGoods(resultSet);
                if(goods==null){
                    System.out.println("没有该商品");

                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close((com.mysql.jdbc.Connection) connection,preparedStatement,null);
        }
        return goods;
    }

    public Goods extractGoods(ResultSet resultSet) throws SQLException{
        Goods goods = new Goods();
        goods.setId(resultSet.getInt("id"));
        goods.setName(resultSet.getString("name"));
        goods.setIntroduce(resultSet.getString("introduce"));
        goods.setStock(resultSet.getInt("stock"));
        goods.setUnit(resultSet.getString("unit"));
        goods.setPrice(resultSet.getInt("price"));
        goods.setDiscount(resultSet.getInt("discount"));
        return goods;

    }
}
