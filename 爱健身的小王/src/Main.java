import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n>0){
            int a = scanner.nextInt();
            int x =maxplus(4*a,a+1);
            int res = (4*a)/x+1;
            System.out.println(res);
            n--;
        }
    }

    public static int maxplus(int a,int b){
        int tmp=0;
        while(b!=0){
            tmp = a%b;
            a=b;
            b=tmp;
        }
        return a;
    }
}
