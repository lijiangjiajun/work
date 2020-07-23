import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length()==0){
            return null;
        }
        dfs(arr,list,digits,0,"");
        return list;
    }

    public void dfs(String[] arr,List<String> list,String digits,int curDepth,String cur){
        if(cur.length()==digits.length()){
            list.add(cur);
            return;
        }
            int index = digits.charAt(curDepth)-'0';
            String map = arr[index];
            for(int i=0;i<map.length();i++){
                dfs(arr,list,digits,curDepth+1,cur+map.charAt(i));
            }

    }
}