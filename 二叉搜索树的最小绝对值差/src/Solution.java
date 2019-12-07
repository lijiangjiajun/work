/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int ret = Integer.MAX_VALUE;
    private TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        int min;
        if(root.left!=null){
            getMinimumDifference(root.left);
        }
        if(prev!=null){
            min= Math.abs(root.val-prev.val);
            if(min<ret){
                ret=min;
            }
        }
        prev = root;
        if(root.right!=null){
            getMinimumDifference(root.right);
        }
        return ret;
    }
}