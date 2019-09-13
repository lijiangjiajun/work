import java.util.Scanner;
public class Text3{
    public static void main(String[] args){
        String secret="asdfg";
        int i=0;
        Scanner sc = new Scanner(System.in); 
        while(i<3){
            System.out.println("请输入密码");
            String input = sc.nextLine();
            if(input.equals(secret)){
                System.out.println("登陆成功");
                break;
            }
            i++;
        }
        if(i==3){
            System.out.println("老铁登陆失败");
        }
    }
}