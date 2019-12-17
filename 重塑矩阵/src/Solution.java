import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        Queue<Integer> queue = new LinkedList<>();
        if(nums.length*nums[0].length!=r*c){
            return nums;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                queue.add(nums[i][j]);
            }
        }
        int[][] ret = new int[r][c];
        for(int row=0;row<r;row++){
            for(int col=0;col<c;col++){
                ret[row][col]=queue.remove();
            }
        }
        return ret;
    }
}