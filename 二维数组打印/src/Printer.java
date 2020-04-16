import java.util.*;

public class Printer {
    public static int[] arrayPrint(int[][] arr, int n) {
        int[] ret = new int[n*n];
        int startX =0;
        int startY =n-1;
        int i=0;
        while(i<n*n){
            int x = startX;
            int y = startY;
                while (x<=n-1 && y <= n - 1) {
                    ret[i] = arr[x][y];
                    x++;
                    y++;
                    i++;
                }
                if(startY>0){
                    startY--;
                }
                else{
                    startX++;
                }
            }
        return ret;
    }


    public static void main(String[] args) {
        int[][] arr  = new int[4][4];
        int count=1;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                arr[i][j]=count;
                count++;
            }
        }
        System.out.println(arrayPrint(arr, 4));
    }
}