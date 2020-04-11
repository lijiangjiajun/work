import java.util.Scanner;

public class So {
    public static int count=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
//            System.out.println(arr.length);
            int max = countWays(arr,0,0);
            System.out.println(max);
        }
    }

    public static int countWays(int[][] arr,int x, int y) {
        if(x==arr[0].length-1){
            int count=0;
            for(int i=y;i<arr.length;i++){
                count+=arr[x][i];
            }
            return count;
        }
        if(y==arr.length-1){
            int count=0;
            for(int i=x;i<arr[0].length;i++){
                count+=arr[i][y];
            }
            return count;
        }
        return arr[x][y]+max(countWays(arr,x+1,y),countWays(arr,x,y+1));
    }

    public static int max(int a,int b){
        return a>b?a:b;
    }
}
