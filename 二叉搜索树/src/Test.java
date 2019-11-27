public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.build();
        tree.remove(23,root);
        tree.prev(root);
    }
}
