import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public class InputDemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("D:\\输入输出流测试文件\\test.java");
        String message =getString(inputStream);
        System.out.println(message);
    }

    public static String getString(InputStream inputStream) throws IOException {
//        byte[] b = new byte[8192];
//        int len = 8192;
//        for(int i=0;i<len;i++){
//            int tmp=inputStream.read();
//            if(tmp!=-1){
//                b[i]=(byte)tmp;
//            }
//        }
//       String ret = new String(b,0,len,"UTF-8");

//        byte[] buffer = new byte[8192];
//        int len=inputStream.read(buffer);
//        String s = new String(buffer, 0, len, "UTF-8");
//        return s;

        Scanner scanner = new Scanner(inputStream,"UTF-8");
        StringBuffer sb = new StringBuffer();
        while(scanner.hasNext()){
            sb.append(scanner.nextLine());
        }
        return sb.toString();
    }
}
