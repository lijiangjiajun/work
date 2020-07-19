import java.util.*;
class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord==null || endWord==null || !wordList.contains(endWord)){
            return 0;
        }
        if(beginWord==endWord){
            return 1;
        }
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visit = new HashSet<>();
        visit.add(beginWord);
        int count=1;
        while(!queue.isEmpty()){
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                String str = queue.poll();
                for (int k = 0; k < endWord.length(); k++) {
                    StringBuffer sb = new StringBuffer(str);
                    for (char i = 'a'; i <= 'z'; i++) {
                        StringBuffer sb2 = new StringBuffer(sb);
                        sb2.setCharAt(k, i);
                        if(sb2.toString().equals(endWord)) {
                            return count+1;
                        }
                        if (dict.contains(sb2.toString()) && !visit.contains(sb2.toString())) {
                            queue.add(sb2.toString());
                        }
                        visit.add(sb2.toString());

                    }
                }
            }
            count++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String endWord = "log";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(ladderLength(begin, endWord, list));
//        System.out.println(ladderLength("hot", "cog", list));
    }
}

