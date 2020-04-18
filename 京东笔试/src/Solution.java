import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
//组成长方体   给6组 数据
//每组数据代表长和宽，问是否能够组成长方形。
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> str =new ArrayList<>();
        while (n != 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int flag = 0;
            int count = 0;
            while (list.size() != 6) {
                if (list2.size() == 2) {
                    list2 = new ArrayList<>();
                }
                int a = scanner.nextInt();
                list2.add(a);
                int sum = map.getOrDefault(a, 0);
                map.put(a, sum + 1);
                if (list2.size() == 2) {
                    list2.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if (o1 < o2) {
                                return -1;
                            }
                            if (o1 > o2) {
                                return 1;
                            }
                            if (o1 == o2) {
                                return 0;
                            }
                            return 0;
                        }
                    });
                    list.add(list2);
                }


            }
//                System.out.println(list);

            for (Integer i : map.keySet()) {
                if (map.get(i) == 4) {
                    continue;
                } else {
                    flag = 1;
                }
            }

            ArrayList<Integer> list3 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = 1; j < list.size(); j++) {
                    if (i!=j && !list3.contains(i) && !list3.contains(j) &&
                            list.get(i).get(0).equals(list.get(j).get(0))  &&
                            list.get(i).get(1).equals(list.get(j).get(1))
                    ) {
                        list3.add(i);
                        list3.add(j);
                        count++;
                        break;
                    }
                }
            }
            if (count == 3 && flag == 0 ) {
                str.add("POSSIBLE");
            }
            if(flag==1 || count!=3){
                str.add("IMPOSSIBLE");
            }
            n--;
        }
        for(int i=0;i<str.size();i++){
            System.out.println(str.get(i));
        }
    }
}
