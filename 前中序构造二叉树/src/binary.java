import javafx.scene.control.cell.CheckBoxListCell;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class binary {
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=0;
        if(preorder.length==0){
            return null;
        }
        return helper(preorder,inorder,0,preorder.length);
    }

    public TreeNode helper(int[] preorder,int[] inorder,int left,int right){
        if(left>=right){
            return null;
        }
        if(index>=preorder.length){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int pos = find(inorder,left,right,root.val);
        root.left = helper(preorder,inorder,left,pos);
        root.right = helper(preorder,inorder,pos+1,right);
        return root;
    }

    public int find(int[] inorder,int left,int right,int val){
        for(int i=left;i<right;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
}
