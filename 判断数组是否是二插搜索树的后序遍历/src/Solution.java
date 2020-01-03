import java.util.*;
public class Solution {
    public static boolean  VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }
       return  help(sequence,0,sequence.length-1);
    }

    public static boolean help(int[] sequence,int left,int right ){
        if(left>=right){
            return true;
        }
        int i=left;
        while(i<right && sequence[i]<sequence[right]){
            i++;
        }

        for(int j=i; j<right; j++){
            if(sequence[j]<sequence[right])
                return false;
        }
        return (help(sequence,left,i-1) && help(sequence,i,right-1));
    }

    public static void main(String[] args){
        int []arr = {5,9,6,12,17,15,10};
        System.out.println(VerifySquenceOfBST(arr));

    }
}