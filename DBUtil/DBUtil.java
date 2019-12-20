import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private static final String URL =  "jdbc:mysql://localhost:3306/Tommy";
    private static final String USERNAME = "root";
    private static final String PASSWORD ="";

    private static DataSource DATASOURCE = new MysqlDataSource();
    static {
        ((MysqlDataSource)DATASOURCE).setUrl(URL);
        ((MysqlDataSource)DATASOURCE).setUser(USERNAME);
        ((MysqlDataSource)DATASOURCE).setPassword(PASSWORD);
    }

    private static DataSource DATASOURCE2 = new MysqlDataSource();

    public static Connection getConnection1(){
        Connection connection =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("数据库连接失败");
            }
        }
        return connection;
    }

    public static Connection getConnection2(){
        try {
            return (Connection) DATASOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库连接失败");
        }
    }

    public static DataSource getDataSource(){
        if(DATASOURCE2==null){
            DATASOURCE2= new MysqlDataSource();
        }
        ((MysqlDataSource)DATASOURCE2).setURL(URL);
        ((MysqlDataSource)DATASOURCE).setUser(USERNAME);
        ((MysqlDataSource)DATASOURCE2).setPassword(PASSWORD);
        return DATASOURCE2;
    }


    public static void close(Connection connection,Statement statement,
                             ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
           throw new RuntimeException("数据库资源释放失败");
        }
    }
}
