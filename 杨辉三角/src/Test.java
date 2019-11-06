import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows==0){
            return ret;
        }
        List<Integer> firstline = new ArrayList<>();
        firstline.add(1);
        ret.add(firstline);
        if(numRows==1){
            return ret;
        }
        List<Integer> secondline = new ArrayList<>();
        secondline.add(1);
        secondline.add(1);
        ret.add(secondline);
        if(numRows==2){
            return ret;
        }

        for(int row=3;row<=numRows;row++){
            List<Integer> cur =new ArrayList<>();
            List<Integer> prev = new ArrayList<>();
            prev = ret.get(row-2);
            cur.add(1);
            for(int col=1;col<row-1;col++){
                cur.add(prev.get(col)+prev.get(col-1));
            }
            cur.add(1);
            ret.add(cur);
        }
        return ret;
    }
}