import java.util.Scanner;
public class Test7{
    public static void main(String[] args){
         Scanner sc= new Scanner(System.in);
         System.out.println("请输入盘子的数量");
         int n = sc.nextInt();
         char A='A';
         char B='B';
         char C='C';
         Hanota(n,A,B,C);
    }
    public static void Move(char A,char B){
         System.out.print(A+"->"+B+' ');
    }
    public static void Hanota(int n,char A,char B,char C){
         if(n==1){
             Move(A,C);
         }
         else
         {
             Hanota(n-1,A,C,B);
             Move(A,C);
             Hanota(n-1,B,A,C);
         }
         
    }
}