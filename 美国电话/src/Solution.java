//import java.util.*;
//
//public class Solution {
//    public static ArrayList<ArrayList<String>> lists = new ArrayList<>();
//    public static void main(String[] args) {
//        String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
//        String number="222333444555666777788899991234567890";
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            String x = scanner.nextLine();
//            int n = Integer.parseInt(x);
//            ArrayList<String> list = new ArrayList<>();
//            String[] arr =  new String[n];
//            scanner.nextLine();
//            for(int i=0;i<n;i++){
//                arr[i]=scanner.nextLine();
//            }
//            for(int i=0;i<n;i++){
//                String str = arr[i];
//                str=str.replace("-","");
//                String sb = "";
//                for(int j=0;j<7;j++){
//                    if(j==3){
//                        sb=sb+"-";
//                    }
//                    sb = sb+number.charAt(symbol.indexOf(str.charAt(j)+""));
//                }
//            if(!list.contains(sb)){
//                list.add(sb);
//            }
//            }
//            Collections.sort(list);
//            for(int i=0;i<list.size();i++){
//                System.out.println(list.get(i));
//            }
//        }
//
//    }
//}
//



import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static ArrayList<ArrayList<String>> lists = new ArrayList<>();
    public static void main(String[] args) {
        String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number="222333444555666777788899991234567890";
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String x = scanner.nextLine();
            int n = Integer.parseInt(x);
            ArrayList<String> list = new ArrayList<>();
            String[] arr =  new String[n];
//            scanner.nextLine();
            for(int i=0;i<n;i++){
                String str = scanner.nextLine();
                System.out.println(i+"="+str);
            }
            System.out.println();
//            for(int i=0;i<n;i++){
//                String str = arr[i];
//                str=str.replace("-","");
//                String sb = "";
//                for(int j=0;j<7;j++){
//                    if(j==3){
//                        sb=sb+"-";
//                    }
//                    sb = sb+number.charAt(symbol.indexOf(str.charAt(j)+""));
//                }
//                if(!list.contains(sb)){
//                    list.add(sb);
//                }
//            }
//            Collections.sort(list);
//            for(int i=0;i<list.size();i++){
//                System.out.println(list.get(i));
//            }
        }

    }
}
