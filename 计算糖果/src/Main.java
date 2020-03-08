import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] str2= str.split(" ");
            int[] arr = new int[str2.length];
            for(int i=0;i<str2.length;i++){
                arr[i]=Integer.parseInt(str2[i]);
            }
            int A=(arr[0]+arr[2])/2;
            int B=A-arr[0];
            int C=arr[3]-B;
            if( (A>=-30 && A<=30) && (B>=-30 && B<=30) && (C>=-30 && C<=30) && B-C==arr[1] )
            {
                System.out.println(A+" "+B+" "+C);
            }
            else{
                System.out.println("No");
            }
        }
    }
}