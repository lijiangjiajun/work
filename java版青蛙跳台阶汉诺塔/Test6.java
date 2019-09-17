import java.util.Scanner;
public class Test6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        int n = sc.nextInt();
        int ret = fib(n);
        System.out.println(ret);
    }
    public static int fib(int n){
        int a=1;
        int b=2;
        int tmp=0;
        for(int i=0;i<=n-3;i++){
              tmp=a+b;
              a=b;
              b=tmp;
        }
        return tmp;
    }
}