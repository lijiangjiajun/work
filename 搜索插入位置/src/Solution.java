class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target<=nums[0]){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
            if(nums[i]>target){
                return i;
            }

            if(nums[i]<target &&i!=nums.length-1){
                continue;
            }
            if(i==nums.length-1){
                return i+1;
            }

        }
        return 0;
    }
}