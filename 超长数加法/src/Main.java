import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            BigInteger a = new BigInteger(str1);
            BigInteger b = new BigInteger(str2);
            System.out.println(a.add(b));
        }
    }
}