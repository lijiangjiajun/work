public class Test {
    public static void main(String[] args) {
        binary tree = new binary();
        Node root = tree.buildTree();
        tree.lowestCommonAncestor(root,tree)
    }
}
