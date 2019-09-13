import java.util.Scanner;
public class Text6{
    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        int input = sc.nextInt();
        int [] a={-1,-1,-1,-1,-1,-1,-1,-1};
        int i=0;
        while(input!=0){
           a[i]=input%10;
           input=input/10;
           i++;
        }
        i=0;
        while(a[i]!=-1){
            System.out.println(a[i]);
            i++;
        }
        sc.lcose();
    }
}