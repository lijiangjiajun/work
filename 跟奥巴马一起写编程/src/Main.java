import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] str2 = str.split(" ");
        int a = Integer.parseInt(str2[0]);
        char b = str2[1].charAt(0);
        for(int i=0;i<a;i++){
            System.out.print(b);
        }
        System.out.println();
        int row=0;
        if(a%2==0){
            row=a/2;
        }
        else{
            row=a/2+1;
        }
        for(int j=0;j<row-2;j++){
            System.out.print(b);
            for(int k=0;k<a-2;k++){
                System.out.print(" ");
            }
            System.out.print(b);
            System.out.println();
        }
        for(int i=0;i<a;i++){
            System.out.print(b);
        }
    }
}