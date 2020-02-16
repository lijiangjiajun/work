class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i-count]==val){
                count++;
                for(int j=i-count+1;j<len-1;j++){
                    nums[j]=nums[j+1];
                }
            }
        }
        return len-count;
    }
}