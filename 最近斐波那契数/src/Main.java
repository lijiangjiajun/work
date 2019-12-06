import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int x = in.nextInt();
            int count=0;
            int i=0;
            for(;i<x;i++){
                if(fib(i)>=x){
                    count=fib(i)-x;
                    break;
                }
            }
            if((x-fib(i-1))<count){
                count=x-fib(i-1);
            }
            System.out.println(count);
        }
    }

    public static int fib(int n){
        if(n==0){
            return 0;
        }
        if(n==2 || n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}