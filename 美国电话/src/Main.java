//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Scanner;
//public class Main {
//    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int n = in.nextInt();
//            int m = in.nextInt();
//            int[] arr = new int[n];
//            for(int i=0;i<arr.length;i++){
//                arr[i]=i+1;
//            }
//            child(arr,m);
//            Collections.sort(list, new Comparator<ArrayList<Integer>>() {
//                @Override
//                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
//                    for(int i=0;i<o2.size();i++){
//                        if(i<o1.size() && o1.get(i)<o2.get(i)){
//                            return -1;
//                        }
//                        if(i<o1.size() && o1.get(i)<o2.get(i)){
//                            return 1;
//                        }
//                    }
//                    return 0;
//                }
//            });
//            for(int i=0;i<list.size();i++){
//                for(int j=0;j<list.get(i).size();j++){
//                    System.out.print(list.get(i).get(j));
//                    if(j!=list.get(i).size()-1){
//                        System.out.print(" ");
//                    }
//                }
//                System.out.println();
//            }
//        }
//    }
//
//    public static void child(int[] arr, int m){
//        int n = (int)Math.pow(2,arr.length);
//        for(int i=1;i<n;i++){
//            ArrayList<Integer> list2 = new ArrayList<>();
//            int index = 0;
//            int pos = i;
//            int sum = 0;
//            while(pos>0){
//                if((pos&1)==1){
//                    list2.add(arr[index]);
//                    sum=sum+arr[index];
//                }
//                pos=pos>>1;
//                index++;
//            }
//            if(sum==m){
//                list.add(list2);
//            }
//        }
//    }
//}




import java.util.*;

public class Main{
    public static void main(String[] args){
        String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number="222333444555666777788899991234567890";
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            ArrayList<String> arrayList=new ArrayList<String>();
            for(int i=0;i<n;i++){
                String str=scanner.next();
                str=str.replace("-","");
                String result="";
                for(int j=0;j<7;j++){
                    result+=number.charAt(symbol.indexOf(str.charAt(j)+""));
                }
                result=result.substring(0,3)+"-"+result.substring(3,7);
                if(!arrayList.contains(result))
                    arrayList.add(result);
            }
            Collections.sort(arrayList);
            for(int j=0;j<arrayList.size();j++){
                System.out.println(arrayList.get(j));
            }
            System.out.println();
        }
    }
}