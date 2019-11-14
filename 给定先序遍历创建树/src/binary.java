import java.util.Scanner;
class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}

public class binary {

    public int index = 0;
    public TreeNode buildTree(String line) {
        char c = line.charAt(index);
        if(c=='#'){
            return null;
        }
        TreeNode root = new TreeNode(c);
        index++;
        root.left = buildTree(line);
        index++;
        root.right = buildTree(line);
        return root;
    }


    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}

