public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        if(m==0 || A.length==0){
            return 0;
        }
        //数组代表放入第i个物品剩余空间为j的最大价值
        int[][] arr = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] > j) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    //放的下的情况
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - A[i - 1]] + V[i - 1]);
                }

            }

        }
        return arr[A.length ][m ];
    }
}