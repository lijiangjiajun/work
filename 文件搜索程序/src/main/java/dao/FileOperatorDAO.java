//package dao;
//
//import app.FileMeta;
//import util.DBUtil;
//import util.Pinyin4jUtil;
//
//import java.io.File;
//import java.net.URISyntaxException;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FileOperatorDAO {
//    public static List<FileMeta> query(String dirpath) {
//        Connection connection = null;
//        PreparedStatement statement=null;
//        ResultSet resultSet=null;
//        List<FileMeta> metas = new ArrayList<>();
//        try{
//            connection = DBUtil.getConnection();
//            String sql ="select name, path,'size'," +
//                    "last_modified,is_directory from file_meta where path=?";
//            statement = connection.prepareStatement(sql);
//            statement.setString(1,dirpath);
//            resultSet = statement.executeQuery();
//            while(resultSet.next()){
//                String name = resultSet.getString("name");
//                String path = resultSet.getString("path");
//                Long size = resultSet.getLong("size");
//                long last_modified = resultSet.getLong("last_modified");
//                boolean is_directory = resultSet.getBoolean("is_directory");
//                FileMeta meta=new FileMeta(name,path,size,last_modified,is_directory);
//                metas.add(meta);
//            }
//        }catch(Exception e){
//
//        }
//        finally {
//            DBUtil.close(connection,statement,null);
//        }
//        return metas;
//    }
//
//    public static void insert(FileMeta localMeta) {
//        Connection connection = null;
//        PreparedStatement statement =null;
//        try{
//            connection = DBUtil.getConnection();
//            String sql = "insert into file_meta(name" +
//                    ", path, size, last_modified, pinyin, " +
//                    "pinyin_first, is_directory)" +
//                    "values (?,?,?,?,?,?,?)";
//
//
//            statement = connection.prepareStatement(sql);
//            statement.setString(1,localMeta.getName());
//            statement.setString(2,localMeta.getPath());
//            statement.setLong(3,localMeta.getSize());
//            statement.setTimestamp(4,
//                    new Timestamp(localMeta.getLastModified()));
//            String pinyin=null;
//            String pinyin_first=null;
//            if(Pinyin4jUtil.containsChinese(localMeta.getName())){
//                String[] pinyins=Pinyin4jUtil.get(localMeta.getName());
//                pinyin = pinyins[0];
//                pinyin_first=pinyins[1];
//            }else{
//                statement.setString(5,pinyin);
//                statement.setString(6,pinyin_first);
//            }
//
//            statement.setBoolean(7,localMeta.getDirectory());
//            statement.executeUpdate();
//            System.out.println("插入成功");
//        }catch(SQLException | URISyntaxException e ){
//            e.printStackTrace();
//        }
//        finally {
//            DBUtil.close(connection,statement,null);
//        }
//    }
//
//
//    public static void delete(FileMeta meta)  {
//        Connection connection = null;
//        PreparedStatement statement =null;
//        try{
//            connection = DBUtil.getConnection();
//            connection.setAutoCommit(false);
//            String sql = "delete from file_meta where name=?" +
//                    " and path=? and is_directory=?";
//
//            statement = connection.prepareStatement(sql);
//            statement.setString(1,meta.getName());
//            statement.setString(2,meta.getPath());
//            statement.setBoolean(3,meta.getDirectory());
//            statement.executeUpdate();
//            //    删除子文件/子文件夹
//            if(meta.getDirectory()){
//                sql="delete from file_meta where path=? or path like ?";
//                statement=connection.prepareStatement(sql);
//                String path=meta.getPath()+ File.separator+meta.getName();
//                statement.setString(1, path);
//                statement.setString(2, path+File.separator+"%");
//                statement.executeUpdate();
//            }
//            connection.commit();
//        }
//        catch(SQLException | URISyntaxException e){
//            e.printStackTrace();
//            if(connection!=null){
//                try {
//                    connection.rollback();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }finally {
//            DBUtil.close(connection,statement,null);
//        }
//    }
//
//    public static void main(String[] args) {
//        insert(new FileMeta("输入输出流测试文件","D:\\输入输出流测试文件"
//                ,0L, 0L,true));
//    }
//
//
//    public static List<FileMeta> search(String dir, String text) {
//        List<FileMeta> metas = new ArrayList<>();
//        Connection connection = null;
//        PreparedStatement statement=null;
//        ResultSet resultSet=null;
//        try{
//            connection = DBUtil.getConnection();
//            boolean empty=dir==null || dir.trim().length()==0;
//            String sql ="select name, path,'size'," +
//                    "last_modified,is_directory from file_meta where" +
//                    " (name like ? or pinyin like ? or pinyin_first like ?)"
//                    + (empty ? "":"and (path=? or path like ?)");
//            statement = connection.prepareStatement(sql);
//            statement.setString(1,"%"+text+"%");
//            statement.setString(2,"%"+text+"%");
//            statement.setString(3,"%"+text+"%");
//            if(!empty){
//                statement.setString(4,dir);
//                statement.setString(5,dir+File.separator+"%");
//            }
//            System.out.println("search path="+dir+ ","+text);
//            resultSet = statement.executeQuery();
//            while(resultSet.next()){
//                String name = resultSet.getString("name");
//                String path = resultSet.getString("path");
//                Long size = resultSet.getLong("size");
//                long last_modified = resultSet.getLong("last_modified");
//                boolean is_directory = resultSet.getBoolean("is_directory");
//                FileMeta meta=new FileMeta(name,path,size,last_modified,is_directory);
//                System.out.println("search:" +name+","+path);
//                metas.add(meta);
//            }
//        }catch(Exception e){
//
//        }
//        finally {
//            DBUtil.close(connection,statement,null);
//        }
//        return metas;
//
//    }
//}

package dao;

import app.FileMeta;
import util.DBUtil;
import util.Pinyin4jUtil;

import java.io.File;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperatorDAO {

    public static List<FileMeta> query(String dirPath) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<FileMeta> metas = new ArrayList<>();
        try{
            connection = DBUtil.getConnection();
            String sql = "select name, path, size, last_modified, is_directory" +
                    " from file_meta where path=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, dirPath);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("name");
                String path = resultSet.getString("path");
                long size = resultSet.getLong("size");
                long last_modified = resultSet.getLong("last_modified");
                boolean is_directory = resultSet.getBoolean("is_directory");
                FileMeta meta = new FileMeta(name, path, size, last_modified, is_directory);
                System.out.println("query: "+name+", "+path);
                metas.add(meta);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return metas;
    }

    public static void insert(FileMeta localMeta) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            try {
                // 1.获取连接
                try {
                    connection = DBUtil.getConnection();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                String sql = "insert into file_meta" +
                        " (name, path, is_directory, pinyin," +
                        " pinyin_first, size, last_modified)" +
                        " values (?,?,?,?,?,?,?)";

                // 2.获取操作命令对象
                statement = connection.prepareStatement(sql);
                // 填充占位符
                statement.setString(1, localMeta.getName());
                statement.setString(2, localMeta.getPath());
                statement.setBoolean(3, localMeta.getDirectory());
                String pinyin = null;
                String pinyin_first = null;

                // 包含中文字符时，需要保存全拼和拼音首字母
                if(Pinyin4jUtil.containsChinese(localMeta.getName())){
                    String[] pinyins = Pinyin4jUtil.get(localMeta.getName());
                    pinyin = pinyins[0];
                    pinyin_first = pinyins[1];
                }
                statement.setString(4, pinyin);
                statement.setString(5, pinyin_first);
                statement.setLong(6, localMeta.getSize());
                statement.setTimestamp(7,
                        new Timestamp(localMeta.getLastModified()));
                System.out.println("insert:"+localMeta.getName()+", "+localMeta.getPath());
                // 3.执行sql语句
                statement.executeUpdate();
            } finally {
                DBUtil.close(connection, statement,null);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void delete(FileMeta meta) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1.获取连接
            try {
                connection = DBUtil.getConnection();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            connection.setAutoCommit(false);
            String sql = "delete from file_meta where name=?" +
                    " and path=? and is_directory=?";
            // 2.获取操作命令对象
            statement = connection.prepareStatement(sql);
            // 填充占位符
            statement.setString(1, meta.getName());
            statement.setString(2, meta.getPath());
            statement.setBoolean(3, meta.getDirectory());
            // 3.执行sql语句
            statement.executeUpdate();
            // 删除子文件/子文件夹
            if(meta.getDirectory()){
                sql = "delete from file_meta where path=? or path like ?";
                statement = connection.prepareStatement(sql);
                // meta path=d:/ name=abc
                // name=hello path=d:/abc
                // name=world path=d:/abc/....
                String path = meta.getPath()+ File.separator+meta.getName();
                statement.setString(1, path);
                statement.setString(2,
                        path+File.separator+"%");
                System.out.println("delete like:"+meta.getPath()+ File.separator+meta.getName());
                statement.executeUpdate();
            }
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.close(connection, statement,null);
        }
    }


    public static void main(String[] args) {
//        System.out.println(query("D:\\maven-test - 副本"));;
        delete(new FileMeta("Downloads", "D:\\",
                0L, 0L, true));
    }

    /**
     * path=""
     * path="D:/"
     * @param path
     * @param text
     * @return
     */
    public static List<FileMeta> search(String dir, String text) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<FileMeta> metas = new ArrayList<>();
        try{
            connection = DBUtil.getConnection();
            boolean empty = dir==null || dir.trim().length()==0;
            // D:\TMP\maven-test - 副本\新建文件夹
            // name=新建文件夹 path=D:\TMP\maven-test - 副本
            String sql = "select name, path, size, last_modified, is_directory" +
                    " from file_meta where (name like ? or pinyin like ?" +
                    " or pinyin_first like ?)"
                    + (empty ?
                    "" : " and (path=? or path like ?)");
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+text+"%");
            statement.setString(2, "%"+text+"%");
            statement.setString(3, "%"+text+"%");
            if(!empty){
                statement.setString(4, dir);
                statement.setString(5, dir+File.separator+"%");
            }
            System.out.println("search path="+dir+", "+"text="+text);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("name");
                String path = resultSet.getString("path");
                long size = resultSet.getLong("size");
                long last_modified = resultSet.getLong("last_modified");
                boolean is_directory = resultSet.getBoolean("is_directory");
                FileMeta meta = new FileMeta(name, path, size, last_modified, is_directory);
                metas.add(meta);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return metas;
    }
}

