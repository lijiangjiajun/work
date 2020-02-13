package servlet;


import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/delGoods")
public class DelGoodsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String goodsId = req.getParameter("id");
        System.out.println(goodsId);
        int goodsid= Integer.parseInt(goodsId);

        Connection connection=null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "delete from goods where id =?";
            connection = DBUtil.getConnection(true);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goodsid);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close((com.mysql.jdbc.Connection) connection,preparedStatement,null);
        }


    }
}
