import java.util.ArrayList;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle==null){
            return 0;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList(triangle);
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                list.get(i).set(j,Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))+triangle.get(i).get(j));
            }
        }
        return list.get(0).get(0);
    }

}