import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            int tmp=0;
            for(int i=0;i<n;i++){
                tmp=tmp^arr[i];
            }
            int pos = 0;
            while((1&tmp)==0){
                pos++;
                tmp=tmp>>1;
            }
            int sum1=0;
            int sum2=0;
            for(int i=0;i<n;i++){
                int x = arr[i]>>pos;
                if((x&1)==1){
                    sum1=sum1^arr[i];
                }
                else{
                    sum2=sum2^arr[i];
                }
            }
            if(sum1<sum2){
                System.out.println(sum1+" "+sum2);
            }
            else{
                System.out.println(sum2+" "+sum1);
            }
        }
    }
}
