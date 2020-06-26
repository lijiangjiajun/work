import java.util.*;


public class Solution {
    /**
     *
     * @param S string字符串 
     * @param T string字符串 
     * @return int整型
     */
    public int numDistinct (String S, String T) {
        int[][] num = new int[S.length()+1][T.length()+1];
        num[0][0]=1;
        for(int i = 1; i <= T.length(); ++i){
            num[0][i] = 0;
        }
         for(int i = 1; i <= S.length(); ++i) {
             num[i][0] = 1;
         }
        for(int i=1;i<=S.length();i++){
            for(int j=1;j<=T.length();j++){
                if(S.charAt(i-1)==T.charAt(j-1)) {
                    num[i][j] = num[i-1][j-1]+num[i-1][j];
                }
                else{
                    num[i][j]=num[i-1][j];
                }
            }
        }
        return num[S.length()][T.length()];
    }
}
