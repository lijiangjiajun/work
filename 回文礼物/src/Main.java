import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int count = 0;
        for (int i = 0; i < A.length()-1; i++) {
            String str1=A.substring(0,i+1);
            String str2=A.substring(i+1);
            StringBuffer sb=new StringBuffer();
            sb.append(str1);
            sb.append(B);
            sb.append(str2);
            if(isret(sb.toString())){
                count++;
            }
        }
        StringBuffer sb1=new StringBuffer();
        StringBuffer sb2=new StringBuffer();
        sb1.append(A);
        sb1.append(B);
        if(isret(sb1.toString())){
            count++;
        }
        sb2.append(A);
        sb2.append(B);
        if(isret(sb2.toString())){
            count++;
        }
        System.out.println(count);
    }

    public static boolean isret(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

