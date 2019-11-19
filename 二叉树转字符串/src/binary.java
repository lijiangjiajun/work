class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;
}

public class binary {
    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t==null){
            return "";
        }
        helper(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public void helper(TreeNode root){
        if(root==null){
            return ;
        }
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        helper(root.left);
        if(root.left==null && root.right!=null){
            stringBuilder.append("()");
        }
        helper(root.right);
        stringBuilder.append(")");

    }
}
