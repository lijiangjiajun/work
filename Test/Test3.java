import java.util.Scanner;
public class Test3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        int n=  sc.nextInt();
        print(n);
    }
    public static void print(int n){
        if(n>9){
           
            print(n);
        }
        System.out.println(n%10);

    }
}