import java.util.Scanner;
import java.util.Random;
public class Text7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random  ra = new Random();
        int rand = ra.nextInt(100);
        int guess=-1;
        System.out.println("输入0退出游戏");
        while(rand!=guess){
            System.out.println("请输入1-100之间的数字");
            guess = sc.nextInt();
            if(guess==0){
                break;
            }
            if(guess<rand){
                System.out.println("小了");
            }
                else if(guess>rand){
                    System.out.println("大了");
                }
                if(guess>100 || guess < 1){
                    System.out.println("输入错误，请重新输入");
                }
        }
        if(guess==rand){
            System.out.println("猜对了");
        }
        else{
            System.out.println("退出成功");
        }
    }
}