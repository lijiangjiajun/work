import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int left = -1;
                int right= -1;
                int tmp=i;
                while(tmp>=0 && arr[tmp]>=arr[i]){
                    tmp--;
                }
                if(tmp>=0){
                    left=tmp;
                }
                tmp=i;
                while(tmp<n && arr[tmp]>=arr[i]){
                    tmp++;
                }
                if(tmp<n){
                    right=tmp;
                }
                System.out.println(left+" "+right);
            }
        }
    }
}
