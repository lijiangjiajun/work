import java.util.*;


public class Solution {
    /**
     *
     * @param word1 string字符串 
     * @param word2 string字符串 
     * @return int整型
     */
    //horse  ros
    public int minDistance (String word1, String word2) {
        //word1的前i个字符转换为word2的前j个字符需要的数
        int[][] arr = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            arr[i][0] = i;
        }
        for(int i=0;i<=word2.length();i++){
            arr[0][i] = i;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j = 1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1];   //相等的时侯替换
                }
                else{
                    arr[i][j] = arr[i-1][j-1]+1;//不相等的时候替换
                }
                int tmp = Math.min(arr[i-1][j]+1,arr[i][j-1]+1); //删除/增添的最小值
                arr[i][j] = Math.min(tmp,arr[i][j]);
            }
        }
        return arr[word1.length()][word2.length()];
    }
}