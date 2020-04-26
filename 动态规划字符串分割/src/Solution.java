import java.util.Set;
public class Solution {
public boolean wordBreak(String s, Set<String> dict) {
boolean[] canBreak = new boolean[s.length() + 1];
// 初始化F(0) = true
canBreak[0] = true;//leetleetcode
    for(int i = 1; i <= s.length(); ++i){
        for(int j = 0; j <=i-1; ++j){
// F(i): true{j <i && F(j) && substr[j+1,i]能在词典中找到} OR false
// 第j+1个字符的索引为j
            if(canBreak[j] && dict.contains(s.substring(j,i))){
                canBreak[i] = true;
                break;
            }
        }
    }
    return canBreak[s.length()];
}

//    public static void main(String[] args) {
//        String str = "afgafs";
//        System.out.println(str.substring(1,3));
//    }
}