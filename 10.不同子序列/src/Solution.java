import java.util.*;


public class Solution {
    /**
     *
     * @param S string字符串 
     * @param T string字符串 
     * @return int整型
     */
    public int numDistinct (String S, String T) {
        int[][] arr = new int[S.length()+1][T.length()+1];
        arr[0][0]=1;
        for(int i=0;i<S.length()+1;i++){
            arr[i][0] = 1;
        }
        for(int j=1;j<T.length()+1;j++){
            arr[0][j] = 0;
        }
        for(int i=1;i<S.length()+1;i++){
            for(int j=1;j<T.length()+1;j++){
                if(S.charAt(i-1)==T.charAt(j-1)){
                    arr[i][j] = arr[i-1][j]+arr[i-1][j-1];
                }
                else{
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        return arr[S.length()][T.length()];
    }
}