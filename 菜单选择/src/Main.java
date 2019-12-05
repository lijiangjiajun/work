import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum=0;
        HashMap<String,Integer> map =new HashMap<>();
        while (in.hasNext()) {
            String str = in.next();
            int count =map.getOrDefault(str,0);
            map.put(str,count+1);
        }
        for (String v : map.keySet()) {
            sum++;
        }
        System.out.println(sum);
    }
}