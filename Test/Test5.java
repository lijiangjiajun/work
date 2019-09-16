import java.util.Scanner;
public class Test5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        int n = sc.nextInt();
        int ret = fib(n);
        System.out.println(ret);
    }
    public static int fib(int n){
        if(n==1 || n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}