import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Save {
    public static void main(String[] args) {
        byte[] buffer= "lanmf\nieong".getBytes();
        InputStream inputStream = new ByteArrayInputStream(buffer);
        Scanner scanner = new Scanner(inputStream,"UTF-8");
        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }


    }
}
