import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int[] arr = new int[a];
            int j=0;
            int count=0;
            int flag=0;
            for(int i=1;i<a*a*a;i=i+2){
                count=0;
                int b=a;
                j=i;
                while(b>0){
                    count=count+j;
                    j=j+2;
                    b--;
                }
                if(count==a*a*a){
                    flag=i;
                    break;
                }
            }
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<a;i++){

                sb.append(flag+"");
                flag=flag+2;
                if(i!=a-1){
                    sb.append("+");

                }
            }
            System.out.println(sb.toString());
        }
    }
}