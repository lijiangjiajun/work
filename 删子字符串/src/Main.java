import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            StringBuffer sb = new StringBuffer();
            int flag=0;
            for(int i=0;i<str1.length();i++){
                for(int j=0;j<str2.length();j++){
                    if(str2.charAt(j)==str1.charAt(i)){
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    sb.append(str1.charAt(i));
                }
                flag=0;
            }
            System.out.println(sb.toString());
        }
    }
}