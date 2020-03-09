import java.util.Scanner;

public class Main {
    static int count=0;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int N=scanner.nextInt();
            arr= new int[N];
            for(int i=0;i<arr.length;i++){
                arr[i]=scanner.nextInt();
            }
            count(40,N);
            System.out.println(count);
        }
    }

    public static void count(int spare,int N){
        if(spare==0){
            count++;
            return;
        }
        if(spare<0 || (spare>0 && N<1) ){
            return;
        }

        count(spare-arr[N-1],N-1);
        count(spare,N-1);

    }
}
