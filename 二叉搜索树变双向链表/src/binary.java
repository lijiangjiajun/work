class TreeNode{
   public int val;
   public TreeNode left;
   public TreeNode right;
}

public class binary {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left==null && pRootOfTree.right==null){
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode Tail = left;
        while(Tail!=null && Tail.right!=null){
            Tail=Tail.right;
        }
        if(left!=null){
            Tail.right=pRootOfTree;
            pRootOfTree.left=Tail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(right!=null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left == null ? pRootOfTree : left;
    }

}
