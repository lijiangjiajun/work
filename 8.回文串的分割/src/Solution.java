import java.util.*;

//error
public class Solution {
    /**
     *
     * @param s string字符串 
     * @return int整型
     */
    public static int minCut (String s) {
        if(resum(s)){
            return 0;
        }
        int[] arr = new int[s.length()+1];
        for(int i=0;i<arr.length;i++){
            arr[i] = i-1;
        }

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(resum(s.substring(j,i))) {
                    arr[i] = Math.min(arr[i],arr[j]+1);
                }
            }
        }
        return arr[s.length()];
    }

    public static boolean resum(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minCut("aaaa"));
    }
}