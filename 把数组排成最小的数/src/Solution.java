import java.util.*;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<numbers.length; i++){
           list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                String o1  = integer+"" +t1;
                String o2  = t1+""+integer;
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<list.size();j++){
            sb.append(list.get(j));
        }
        return sb.toString();
    }
}