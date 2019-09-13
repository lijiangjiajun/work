import java.util.Scanner;
public class Text4{
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.println("请输入一个数字");
       int input = sc.nextInt();
        int ret = Count(input);
        System.out.println(ret);
        sc.close();
    }
    public static int Count(int x){
        int count=1;
        int tmp;
        tmp=x&(x-1);
        while(tmp!=0){
            tmp=tmp&(tmp-1);
            count++;
        }
        return count;
    }
}