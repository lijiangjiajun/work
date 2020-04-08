import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//游戏规则：每张卡片有2个属性，一个事可以抽几次卡，另外一种属性是这张卡能够得到的钱，
//问最多能够得到多少钱
public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for(int i=0;i<n;i++){
                list1.add(scanner.nextInt());
                list2.add(scanner.nextInt());
            }
            int count1 = 0;
            int count2 = 1;
            while(count2!=0 && list1.size()!=0){
                count2--;
                int[] arr = max(list2);
                if(arr[0]==0){
                    int[] arr2 = max(list1);
                    count1=count1+arr2[0];
                    list2.remove(arr2[1]);
                    list1.remove(arr2[1]);
                }
                else {
                    count2 = count2 + arr[0];
                    list2.remove(arr[1]);
                    count1 = count1 + list1.get(arr[1]);
                    list1.remove(arr[1]);
                }
            }
            System.out.println(count1);
        }
    }

    public static int[] max(List<Integer> list){
        int[] arr = new int[2];
        int pos=-1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>max){
                max = list.get(i);
                pos=i;
            }
        }
        arr[0]=max;
        arr[1]=pos;
        return arr;
    }
}

