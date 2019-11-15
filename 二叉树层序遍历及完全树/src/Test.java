public class Test {
    public static void main(String[] args) {
        binary tree = new binary();
        Node root = tree.build();
        System.out.println(tree.isComplete(root));
    }

}
