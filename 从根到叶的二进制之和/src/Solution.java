
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
          val = x;
      }
  }

      public class Solution {
          private int sum = 0;

          public int sumRootToLeaf(TreeNode root) {
              help(root, 0);
              return sum;
          }

          public void help(TreeNode root, int val) {
              if (root == null) {
                  return;
              }
              int newVal = val<<1 | root.val;
              if (root.left == null && root.right == null) {
                  sum = sum + newVal;
              } else {
                  help(root.left, newVal);
                  help(root.right, newVal);
              }
          }
      }


