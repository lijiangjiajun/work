import java.util.Scanner;
public class Test2{
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         System.out.println("请输入数字");
         int n = sc.nextInt();
         int ret =  ADD(n);
         System.out.println(ret );
     }
     public static int ADD(int n){
         if(n==1){
             return 1;
         }
         return n+ADD(n-1);
     }
}