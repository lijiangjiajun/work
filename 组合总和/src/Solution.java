import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates,target,ret,list,0,0);
        return ret;
    }

    public void dfs(int[] candidates,int target,List<List<Integer>> ret,List<Integer> list,int sum,int pre){
        if(sum>target){
            return;
        }
        if(sum==target){
            ret.add(list);
            return;
        }
        for(int i=pre;i<candidates.length;i++){
            List<Integer> list2 = new ArrayList<>(list);
            list2.add(candidates[i]);
            dfs(candidates,target,ret,list2,sum+candidates[i],i);
        }
    }
}