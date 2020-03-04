import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int count=0;
        int countnow=0;
        int i=0;
        StringBuffer sb = new StringBuffer();
        StringBuffer sbnow = new StringBuffer();
        while(i<str.length()){
            while(i<str.length() && (str.charAt(i)>='0' && str.charAt(i)<='9') ){
                sbnow.append(str.charAt(i));
                countnow++;
                i++;
            }
            if(countnow>count){
                count=countnow;
                sb=sbnow;
            }
            if(countnow==0){
                i++;
            }
            countnow=0;
            sbnow=new StringBuffer();
        }
        System.out.println(sb.toString());
    }
}