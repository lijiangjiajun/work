package util;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.beans.Statement;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

    private static volatile DataSource DATA_SOURCE;

    private DBUtil(){

    }

    //获取SQLite数据库本地文件路径
    private static String getUrl() throws URISyntaxException {
        String dbName = "xiaotianquan.db";
        URL url = DBUtil.class.getClassLoader().getResource(".");
        return "jdbc:sqlite://" + new File(url.toURI()).getParent()+File.separator+dbName;

    }

    //获取数据库连接池

    private static DataSource getDataSource() throws URISyntaxException {
        if(DATA_SOURCE==null){
            synchronized (DBUtil.class){
                if(DATA_SOURCE==null){
                    //设置日期类型格式
                    SQLiteConfig config = new SQLiteConfig();
                    config.setDateStringFormat(Util.DATA_PATTERN);
                    DATA_SOURCE=new SQLiteDataSource();
                    ((SQLiteDataSource)DATA_SOURCE).setUrl(getUrl());
                }
            }
        }
        return DATA_SOURCE;
    }


    public static Connection getConnection() throws SQLException, URISyntaxException {
       return getDataSource().getConnection();

    }

    public static void close(Connection connection,Statement statement,
                             ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
//            if (statement != null) {
//                statement.close();
//            }
            if (connection != null) {
                connection.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("数据库资源释放失败");
        }
    }


    public static void main(String[] args) throws URISyntaxException, SQLException {
//       URL url= DBUtil.class.getClassLoader().getResource(".");
//        System.out.println((new File(url.toURI()).getParent()));
//        Connection connection = getConnection();
        //获取当前类下的路径
        System.out.println(DBUtil.class.getResource("../init.sql"));
        //getClassLoader()获取到的是class类下的路径
        System.out.println(DBUtil.class.getClassLoader().getResource("./init.sql"));
    }
}
