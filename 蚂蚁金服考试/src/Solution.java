import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            int[] arr =new int[a];
            for(int i=0;i<a;i++){
                arr[i]=scanner.nextInt();
            }
            for(int i=0;i<a;i++){
                System.out.println(arr[i]);
            }
        }
    }
}
