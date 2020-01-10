import java.util.ArrayList;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n==0 || m==0){
            return -1;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(i);
        }
        int pos = 0;
        while(arr.size()>1){
            pos=(pos+m-1)%(arr.size());
            arr.remove(pos);
        }
        return arr.get(0);
    }
}