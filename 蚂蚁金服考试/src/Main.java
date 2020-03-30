import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int sum=0;
            while (in.hasNext()) {
                int n=in.nextInt();
                int m=in.nextInt();
                int k=in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i <n; i++) {
                    arr[i] =in.nextInt();
                }
               while(m>0){
                   for(int i=0;i<n;i++) {
                       arr[i]=arr[i]+k;
                   }
                   int pos = max(arr);
                   arr[pos]=arr[pos]/2;
                   m--;
                   }

               for(int i=0;i<n;i++){
                   sum=sum+arr[i];
               }

                System.out.println(sum);
               }
            }
            public static int max(int[] arr){
            int max=Integer.MIN_VALUE;
            int flag=-1;
            for(int i=0;i<arr.length;i++){
                if(arr[i]>max){
                    max=arr[i];
                    flag=i;
                }
            }
            return flag;
            }
    }





