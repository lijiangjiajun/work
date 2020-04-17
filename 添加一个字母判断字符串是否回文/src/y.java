import java.util.*;
public class y {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
//去掉两端或者本身是否是回文
            if (isPalindrome(s.substring(0, s.length() - 1)) || isPalindrome(s.substring(1,
                    s.length()))|| isPalindrome(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    //这个函数是判断字符串是否为回文串
    public static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}