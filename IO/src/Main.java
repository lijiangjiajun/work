import java.io.File;
import java.io.IOException;

public class Main {

    public static void Printlist(File root) throws IOException {
        if(!root.exists()){
            return;
        }
        File[] files= root.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].isDirectory()) {
               Printlist(files[i]);
            }
            System.out.println(files[i].getCanonicalPath());
            }
        }



    public static void main(String[] args) throws IOException {
        File file = new File("D:\\输入输出流测试文件");
        Printlist(file.getAbsoluteFile());
    }
}
