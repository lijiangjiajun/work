import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<arr.length;i++){
                arr[i] = scanner.nextInt();
            }
            int K= scanner.nextInt();
            int d = scanner.nextInt();  //编号不能超过d
            long  res = Integer.MIN_VALUE;
            long[][] dpmax = new long[K+1][n+1]; //代表已选了i个人在前j个人中的最大值
            long[][] dpmin = new long[K+1][n+1];
            for(int i=1;i<=n;i++){
                dpmax[1][i] = arr[i-1];
                dpmin[1][i] = arr[i-1];
            }
            for(int i=1;i<n+1;i++){
                for(int k=2;k<=K;k++){
                    for(int j=i-1;i-j<=d && j>0;j--){
                        dpmax[k][i] = Math.max(dpmax[k][i], Math.max(dpmax[k-1][j] * arr[i-1], dpmin[k-1][j] * arr[i-1]));
                        dpmin[k][i] = Math.min(dpmin[k][i], Math.min(dpmax[k-1][j] * arr[i-1], dpmin[k-1][j] * arr[i-1]));
                    }
                }
                res = Math.max(res ,dpmax[K][i]);
            }
            System.out.println(res);
        }
    }
}





//public class Main {
//    // 参考 【小刀初试】的算法思想， Java版本，便于理解
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        while (cin.hasNextInt()) {
//            int n = cin.nextInt();          // n 个学生
//            int[] arr = new int [n+1];
//            for (int i = 1; i <=n ; i++) {
//                arr[i] = cin.nextInt();
//            }
//            int K = cin.nextInt();            // 选出K个
//            int d = cin.nextInt();            // 两个学生的位置编号的差不超过 d
//            long[][] fmax = new long[K+1][n+1]; // 记录最大乘积
//            long[][] fmin = new long[K+1][n+1]; // 记录最小乘积
//            // fmax[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最大乘积；
//            // fmin[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最小乘积；
//            //初始化第一行
//            long  res = Integer.MIN_VALUE; // 记得用Long类型，考虑数值范围
//            for (int i = 1; i <=n; i++) {
//                fmax[1][i] = arr[i];
//                fmin[1][i] = arr[i];
//                for (int k = 2; k <=K; k++) {
//                    for (int j = i-1 ; j > 0 &&  i-j<=d ; j--) {
//                        fmax[k][i] = Math.max(fmax[k][i], Math.max(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
//                        fmin[k][i] = Math.min(fmin[k][i], Math.min(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
//                    }
//                }
//                res = Math.max(res ,fmax[K][i]);
//            }
//            System.out.println(res);
//        }
//    }