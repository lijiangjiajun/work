import java.util.ArrayList;
import java.util.List;



//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }
class Solution {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        help(root,"",list);
        return list;
    }

    public static void help(TreeNode node,String cur,List<String> list){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            list.add(cur+node.val);
        }
        else{
            help(node.left,cur+node.val+" ",list);
            help(node.right,cur+node.val+" ",list);
        }
    }

    public static TreeNode build() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = F;
        C.right = G;
        return A;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        List<String> list =  binaryTreePaths(root);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}