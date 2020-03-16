import java.util.Arrays;

public class Main {
    public static String[] getGray(int n) {
        String[] ret = null;
        if(n==1){
            ret = new String[2];
            ret[0]="0";
            ret[1]="1";
            return ret;
        }
        String[] arr = getGray(n-1);
        ret = new String[2*arr.length];
        for(int i=0;i<arr.length;i++){
            ret[i]="0"+arr[i];
            ret[ret.length/2+i]="1"+arr[arr.length-1-i];
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] str =getGray(4);
        System.out.println(Arrays.toString(str));
    }
}

