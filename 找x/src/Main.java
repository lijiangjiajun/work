import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            int a = in.nextInt();
            int pos=-1;
            for(int i=0;i<n;i++){
                if(a==arr[i]){
                    pos=i;
                }
            }
            System.out.println(pos);
        }
    }
}