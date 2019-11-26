import java.util.*;

public class Test {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String key : words) {
            int count = map.getOrDefault(key, 0);
            map.put(key, count + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list,new mycmp(map));
        return list.subList(0,k);
    }

    class mycmp implements Comparator<String> {
        private Map<String,Integer> map = null;
        public mycmp(Map<String,Integer> map){
            this.map =map;
        }


        @Override
        public int compare(String s, String t1) {
            int count1= map.get(s);
            int count2= map.get(t1);
            if(count1>count2){
                return -1;
            }
            if(count1<count2){
                return 1;
            }
            else  {
                return s.compareTo(t1);
            }
        }
    }
}
