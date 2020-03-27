import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            StringBuffer sb = new StringBuffer();
            String str = scanner.nextLine();
            String[] str2 = str.split(",");
            int[] arr =new int[str2.length];
            for(int i=0;i<arr.length;i++){
                arr[i]=Integer.parseInt(str2[i]);
            }
            ArrayList<Integer> list = new ArrayList<>();
            System.out.print(arr[0]-30);
            System.out.print(",");
            for(int i=2;i<arr.length;i=i+2){
                if(arr[i]-arr[i-1]>=60){
                    System.out.print(arr[i-1]+30);
                    System.out.print(arr[i]-30);
                    System.out.print(",");
                }
            }
            System.out.print(arr[arr.length-1]+30);
        }
    }
}
