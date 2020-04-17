import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            System.out.println(Helper(str));
        }
    }

    public static String Helper(String str) {
        int len = str.length();
        int i = len / 2;
        if (len % 2 == 0) {
            if((str.substring(0,i).contains(new StringBuffer(str.substring(i+1)).reverse().toString())) ||
                    str.substring(i).contains(new StringBuffer(str.substring(0,i-1)).reverse().toString())){
                return "YES";
            }
            else {
                return "NO";
            }
        }
        else{
            if (str.substring(0, i + 1).contains(new StringBuffer(str.substring(i + 1))) ||
      str.substring(i).contains(new StringBuffer(str.substring(0,i).toString()))) {
                return "YES";
            }
            return "NO";
        }
    }
}