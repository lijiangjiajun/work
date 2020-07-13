import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static int[][] arr = {{0,1},{1,0},{0,-1},{-1,0}};
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] flag =new int[image.length][image[0].length];
        int pos = image[sr][sc];
        dfs(image,flag,sr,sc,newColor,pos);
        return image;
    }

    public static void dfs(int[][] image,int[][] flag, int sr,int sc,int newColor,int pos){
        if(sr>=image.length || sr<0 || sc>=image[0].length || sc<0){
            return;
        }
        if(flag[sr][sc]==0){
            flag[sr][sc]=1;
            if(pos == image[sr][sc]){
                image[sr][sc] = newColor;
            }
            else{
                return;
            }
            for(int i=0;i<arr.length;i++){
                int x = sr+arr[i][0];
                int y = sc+arr[i][1];
                dfs(image,flag,x,y,newColor,pos);
            }
        }
    }

    public static void main(String[] args) {
        int[][] s =  {{1,1,1},{1,1,0},{1,0,1}};
        int[][]  t = floodFill(s,1,1,2);
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[0].length;j++){
                System.out.println(t[i][j]);
            }
        }
    }
}