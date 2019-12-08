import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){

                if(array[i]+array[j]==sum){
                    if(result.isEmpty()){
                        result.add(array[i]);
                        result.add(array[j]);
                    }
                    else{
                        int tmp1 = result.get(0);
                        int tmp2 = result.get(1);
                        if(array[i]*array[j]<tmp1*tmp2){
                            result.remove(0);
                            result.remove(0);
                            result.add(array[i]);
                            result.add(array[j]);
                        }
                    }
                }
            }
        }
        return result;
    }
}