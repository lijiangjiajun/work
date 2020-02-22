import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<ransomNote.length();i++){
            int flag=0;
            for(int j=0;j<magazine.length();j++){
                if(ransomNote.charAt(i)==magazine.charAt(j)){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                return false;
            }
        }
        for(int i =0;i<magazine.length();i++){
            int count = map.getOrDefault(magazine.charAt(i),0);
            map.put(magazine.charAt(i),count+1);
        }

        for(int j=0;j<ransomNote.length();j++){
            if(map.get(ransomNote.charAt(j))>0){
                map.put(ransomNote.charAt(j),map.get(ransomNote.charAt(j))-1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}