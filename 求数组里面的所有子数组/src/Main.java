import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
    public class Main {
        public static List<ArrayList<Integer>> list =new ArrayList<>();
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()) {
                int n= scanner.nextInt();
                int[] arr = new int[n];
                for(int i=0;i<arr.length;i++){
                    arr[i] = scanner.nextInt();
                }
                group(arr);
                System.out.println(list);
            }

        }

        public static void group(int[] arr){
            int n = (int)Math.pow(2,arr.length);
            for(int i=1;i<n;i++){
                ArrayList<Integer> list2 =new ArrayList<>();
                int tmp=i;
                int index=0;
                while(tmp>0){
                    if((tmp&1)==1){
                        list2.add(arr[index]);
                    }

                    tmp=tmp>>1;
                    index++;
                }
                list.add(list2);
            }
        }
    }


