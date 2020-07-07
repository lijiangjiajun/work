import java.util.*;


public class Solution {
    /**
     *
     * @param grid int整型二维数组 
     * @return int整型
     */
    public static int minPathSum (int[][] grid) {
        if(grid==null){
            return 0;
        }
        int[][] arr = new int[grid.length][grid[0].length];
        arr[0][0]=grid[0][0];
        for(int i=1;i<grid[0].length;i++){
            arr[0][i]=grid[0][i]+arr[0][i-1];
        }
        for(int j=1;j<grid.length;j++){
            arr[j][0]=grid[j][0]+arr[j-1][0];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                arr[i][j]=Math.min(arr[i-1][j],arr[i][j-1])+grid[i][j];
            }
        }
        return arr[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0][0]=1;
        arr[0][1]=3;
        arr[0][2]=1;
        arr[1][0]=1;
        arr[1][1]=5;
        arr[1][2]=1;
        arr[2][0]=4;
        arr[2][1]=2;
        arr[2][2]=1;
        System.out.println(minPathSum(arr));
    }
}