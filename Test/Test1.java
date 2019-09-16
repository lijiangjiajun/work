import java.util.Scanner;
public class Test1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
       int n = sc.nextInt();
       int ret = Return(n);
       System.out.println(ret);
    }
    public static int Return(int n){
       if(n==1){
           return 1;
       }
       return n*Return(n-1);
    }
}