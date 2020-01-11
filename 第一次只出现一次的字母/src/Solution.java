import java.util.HashMap;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<str.length();i++){
            int count = map.getOrDefault(str.charAt(i),0);
            count++;
            map.put(str.charAt(i),count);
        }
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(map.get(c)==1){
                return i;
            }
        }
        return -1;
    }
}