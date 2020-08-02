import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int[] valid1 = new int[str1.length()+1];
        int[] valid2 = new int[str2.length()+1];
        int[][] arr = new int[str1.length()+1][str2.length()+1];
        //str1的前i个字符和str2的前j个字符可以组成的最大组合数
        valid(valid1,str1);
        valid(valid2,str2);
        if(valid1[str1.length()]+valid2[str2.length()]!=0){
            System.out.println(0);
        }
        else {
            arr[0][0] = 1;
            for (int i = 0; i < str1.length() + 1; i++) {
                for (int j = 0; j < str2.length() + 1; j++) {
                    if (valid1[i]+valid2[j]>=0){
                        if(i!=0){
                            arr[i][j]+=arr[i-1][j];
                        }
                        if(j!=0){
                            arr[i][j]+=arr[i][j-1];
                        }
                        arr[i][j]=arr[i][j]%1000000007;
                    }
                }
            }
            System.out.println(arr[str1.length()][str2.length()]);
        }
    }

    public static void valid(int[] valud,String str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                valud[i+1] = valud[i]+1;
            }
            if(str.charAt(i)==')'){
                valud[i+1] = valud[i]-1;
            }
        }
    }
}
