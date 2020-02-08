package task;

import util.DBUtil;

import java.io.*;

public class DBInit {
    public static void init() throws IOException {
        //获取数据库初始化文件的输入流
        InputStream is = DBUtil.class.getClassLoader()
                .getResourceAsStream("init.sql");
        BufferedReader in = new BufferedReader(new InputStreamReader(is,"utf-8"));
        String line;
        StringBuffer sb = new StringBuffer();
        while((line = in.readLine())!=null){
           int idx = line.indexOf("--");
           if(idx!=-1){
               line=line.substring(0,idx);
           }
           sb.append(line);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        init();
    }
}
