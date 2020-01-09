import javax.imageio.stream.ImageInputStream;
import java.util.Arrays;
import java.util.Random;

public class Solution {
    public static boolean isContinuous(int [] numbers) {
        if(numbers.length==0){
            return false;
        }
       int zero = 0;
       int gap=0;
       Arrays.sort(numbers);
       for(int i=0;i<numbers.length;i++){
           if(numbers[i]==0){
               zero++;
           }
       }
       for(int i=zero;i<numbers.length-1;i++){
           if(numbers[i]==numbers[i+1]){
               return false;
           }
       }
       for(int i=zero;i<numbers.length-1;i++){
           gap+=numbers[i+1]-numbers[i]-1;
       }
        if(zero>=gap){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        int[] arr = {1,3,0,5,0};
        System.out.println(isContinuous(arr));
    }
}