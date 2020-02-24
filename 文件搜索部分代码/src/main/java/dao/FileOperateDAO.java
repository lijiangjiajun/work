package dao;

import task.FileScanCallback;
import util.DBUtil;
import util.Pinyin4jUtil;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class FileOperateDAO implements FileScanCallback {
    @Override
    public void execute(File dir) {
        Connection connection = null;
        PreparedStatement statement =null;
        try{
            connection = DBUtil.getConnection();
            String sql = "insert into file_meta(name" +
                    ", path, size, last_modified, pinyin, " +
                    "pinyin_first, is_directory)" +
                    "values (?,?,?,?,?,?,?)";


            statement = connection.prepareStatement(sql);
            statement.setString(1,dir.getName());
            statement.setString(2,dir.getParent());
            statement.setLong(3,dir.length());
            statement.setTimestamp(4,
                    new Timestamp(dir.lastModified()));
            String pinyin=null;
            String pinyin_first=null;
            if(Pinyin4jUtil.containsChinese(dir.getName())){
                String[] pinyins=Pinyin4jUtil.get(dir.getName());
                pinyin = pinyins[0];
                pinyin_first=pinyins[1];
            }else{
                statement.setString(5,pinyin);
                statement.setString(6,pinyin_first);
            }

            statement.setBoolean(7,dir.isDirectory());
            statement.executeUpdate();
        }catch(SQLException | URISyntaxException e){

        }
    }
}
