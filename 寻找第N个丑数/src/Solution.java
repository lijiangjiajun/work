import java.util.*;
public class Solution {
    public static int GetUglyNumber_Solution(int index) {
        if(index==0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        while(list.size()<=index) {

            int m1 = list.get(i1) * 2;
            int m2 = list.get(i2) * 3;
            int m3 = list.get(i3) * 5;
            int min = Math.min(m1, Math.min(m2, m3));
            list.add(min);
            if(min==m1){
                i1++;
            }
            if(min==m2){
                i2++;
            }
            if(min==m3){
                i3++;
            }
        }
        return list.get(index);
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(3));
    }

}