class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class binary {


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
        E.left = G;
        C.right = F;
        return A;
    }

    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right == null){
            return 1;
        }
        return 1+max(maxDepth(root.left),maxDepth(root.right));
    }

    public int max(int a,int b){
        return a>b? a:b;
    }

        public boolean isBalance(TreeNode root){
        if(root == null){
            return true;
        }
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        if(leftdepth-rightdepth>1 || leftdepth-rightdepth<-1){
            return false;
        }
        return isBalance(root.left) &&
        isBalance(root.right);

    }






}
