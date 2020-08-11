import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str = str1.toLowerCase();
        int flag=0;
        for(char i='a';i<'z';i++){
            int index = str.indexOf(i);
            if(index>=0){
                List<Character> list = new ArrayList<>();
                for(int j=index+1;j<str.length();j++){
                    list.add(str.charAt(j));
                }
                for(int j=0;j<index;j++){
                    if(!list.contains(str.charAt(j))){
                        flag=1;
                        break;
                    }
                }
                if(flag==0) {
                    System.out.println(i);
                    break;
                }
                flag=0;
            }
        }

    }
}
