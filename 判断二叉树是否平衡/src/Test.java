import org.w3c.dom.ls.LSOutput;

public class Test {
    public static void main(String[] args) {
        binary tree = new binary();
        TreeNode root = tree.build();
        System.out.println(tree.isBalance(root));
    }
}
