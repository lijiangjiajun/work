import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
      MyString arr = new MyString("ae,sfgr,at,awf");
//
//        System.out.println(arr.MyreplaceAll("a","ggg"));
      String[] str = arr.Mysplit(',');
        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }

    }
}
