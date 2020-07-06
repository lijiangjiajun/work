import java.util.*;


public class Solution {
    /**
     *
     * @param obstacleGrid int整型二维数组 
     * @return int整型
     */
    public static int uniquePathsWithObstacles (int[][] obstacleGrid) {
        int[][] arr = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0]==0)
        arr[0][0]=1;
        for(int i=1;i<obstacleGrid[0].length;i++){
            if(obstacleGrid[0][i]==0 && arr[0][i-1]==1){
                arr[0][i]=1;
            }
            if(obstacleGrid[0][i]==1){
                arr[0][i]=0;
                break;
            }
        }
        for(int i =1;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0]==0 && arr[i-1][0]==1){
                arr[i][0]=1;
            }
            if(obstacleGrid[i][0]==1){
                arr[i][0]=0;
                break;
            }
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(obstacleGrid[i][j]==1){
                    arr[i][j]=0;
                }
                else{
                    arr[i][j]=arr[i-1][j]+arr[i][j-1];
                }

            }
        }
        return arr[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++) {
                arr[i][j]=1;
            }
            }
        System.out.println(uniquePathsWithObstacles(arr));
    }
}