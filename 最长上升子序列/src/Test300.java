public class Test300 {
    public static void main(String[] args) {
        int[] nums = {10,45,224,5,33,2357,23101,128,5434,3458,24576,876543,43};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];  //代表以第i个结尾最长子序列的长度
        for(int i=1;i<dp.length;i++){
            dp[i] = 1;
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<dp.length;i++){
            for(int j=i-1;j>0;j--){
                if(nums[i-1]>nums[j-1]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}
