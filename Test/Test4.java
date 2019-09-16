import java.util.Scanner;
public class Test4{
    public static void main(String[] ars){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        int n = sc.nextInt();
        int ret = ADD(n);
        System.out.println(ret );
    }
    public static int ADD(int n){
        if(n<10){
            return n;
        }
        return n%10+ADD(n/10);
    }
}