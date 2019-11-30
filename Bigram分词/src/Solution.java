import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] ret = text.split(" ");
        List<String> list = new ArrayList<>();
        for(int i=0;i<ret.length-2;i++){
            if(first.equals(ret[i]) && second.equals(ret[i+1])){
                list.add(ret[i+2]);
            }
        }
        String[] a = list.toArray(new String[list.size()]);
        return a;
    }


}
