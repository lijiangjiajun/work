package task;

import util.DBUtil;

import java.beans.Statement;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBInit {
    public static void init() throws IOException {
        Connection connection = null;
        PreparedStatement statement = null;
        //获取数据库初始化文件的输入流
        try {
            InputStream is = DBUtil.class.getClassLoader()
                    .getResourceAsStream("init.sql");
            BufferedReader in = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = in.readLine()) != null) {
                int idx = line.indexOf("--");
                if (idx != -1) {
                    line = line.substring(0, idx);
                }
                sb.append(line);
            }
            String[] sqls = sb.toString().split(";");

            for (String sql : sqls) {
                connection = DBUtil.getConnection();
                statement = connection.prepareStatement(sql);
                statement.executeUpdate();
            }
        }

        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("数据库初始化任务错误");
        }
        finally {
            DBUtil.close(connection,statement,null);
        }

    }

    public static void main(String[] args) throws IOException {
        init();
    }
}
