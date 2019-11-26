import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words = {"hah","lal"};
        Map<String,Integer> map = new HashMap<>();
        for(String key : words){
            int count = map.getOrDefault(key,0);
            map.put(key,count+1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        System.out.println(list);
    }

}
