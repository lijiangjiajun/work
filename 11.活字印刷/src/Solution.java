import java.util.HashSet;

public class Solution {
    public static int count=0;
    public static HashSet<String> set = new HashSet<>();
        public static int numTilePossibilities(String tiles) {
            int[] arr = new int[tiles.length()];
            dfs(tiles,"",arr);
            return count;
        }

        public static void dfs(String tiles, String cur,int[] arr){
            if(cur.length()>tiles.length()){
                return;
            }
            if(!set.contains(cur) && cur!=""){
                count++;
                set.add(cur);
            }
            for(int i=0;i<tiles.length();i++){
                if(arr[i]==0) {
                    arr[i]=1;
                    dfs(tiles, cur + tiles.charAt(i),arr);
                    arr[i]=0;
                }
            }
        }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        for (String str : set) {
            System.out.println(str);
        }
    }
}
