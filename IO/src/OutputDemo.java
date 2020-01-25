import java.io.*;

public class OutputDemo {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("D:\\输入输出流测试文件\\有一个目录\\hello.java");
        String s =  "1234 \n5 6 7";
        byte[] b= s.getBytes("UTF-8");
        outputStream.write(b,0,b.length);

     }
}
