import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public int numJewelsInStones(String J, String S) {
        int count=0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<J.length();i++){
            set.add(J.charAt(i));
        }
        for(int j=0;j<S.length();j++){
            if(set.contains(S.charAt(j))){
                count++;
            }
        }
        return count;
    }
}
