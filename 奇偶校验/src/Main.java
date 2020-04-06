import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            ArrayList<Character> list = new ArrayList<>();
            for(int i=0;i<str.length();i++){
                list.add(str.charAt(i));
            }
            for(int i=0;i<list.size();i++){
                int x = Integer.valueOf(list.get(i));
                StringBuffer sb = new StringBuffer();
                sb.append(Integer.toBinaryString(x));
                while(sb.toString().length()<7){
                    sb.insert(0,"0");
                }
                int count=0;
                for(int j=0;j<sb.toString().length();j++){
                    if(sb.toString().charAt(j)=='1'){
                        count++;
                    }
                }
                if(count%2==1){
                    sb.insert(0,"0");
                }else{
                    sb.insert(0,"1");
                }
                System.out.println(sb.toString());
            }
        }
    }
}