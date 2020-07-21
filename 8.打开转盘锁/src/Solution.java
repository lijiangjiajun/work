import java.util.*;

class Solution {
    public static int openLock(String[] deadends, String target) {
        String start = "0000";
        int count=0;
        Set<String> list = new HashSet<>();
        Set<String> visit = new HashSet<>();
        for(int i=0;i<deadends.length;i++){
            list.add(deadends[i]);
        }
        if(list.contains("0000")){
            return -1;
        }
        if(target.equals("0000") ){
            return 0;
        }
        if(list.contains(target)){
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                String cur = queue.poll();
                if(cur.equals(target)){
                    return count;
                }
                for(int j=0;j<start.length();j++){
                    StringBuffer sb = new StringBuffer(cur);
                    StringBuffer sb2 = new StringBuffer(cur);
                    if(cur.charAt(j)=='9'){
                        sb.setCharAt(j,'0');
                    }
                    else{
                        char c = (char)(cur.charAt(j)+1);
                        sb.setCharAt(j,c);
                    }
                    if(cur.charAt(j)=='0'){
                        sb2.setCharAt(j,'9');
                    }
                    else{
                        char c = (char)(cur.charAt(j)-1);
                        sb2.setCharAt(j,c);
                    }
                    if(sb.toString().equals(target) || sb2.toString().equals(target)){
                        return count+1;
                    }
                    if(!visit.contains(sb.toString()) && !list.contains(sb.toString())) {
                        queue.add(sb.toString());
                    }
                    if(!visit.contains(sb2.toString()) && !list.contains(sb2.toString())) {
                        queue.add(sb2.toString());
                    }
                    visit.add(sb.toString());
                    visit.add(sb2.toString());
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] arr = {"0201","0101","0102","1212","2002"};
        System.out.println(openLock(arr, "0202"));
    }
}