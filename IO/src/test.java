import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\输入输出流测试文件\\有一个目录\\test.java");
        File dest = new File("D:\\输入输出流测试文件\\test.java");
        file.renameTo(dest);
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
    }

}
