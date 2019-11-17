import java.util.List;

public class Test {
    public static void main(String[] args) {
        binary tree = new binary();
        Node root = tree.buildTree();
        List<List<Integer>> list = tree.levelOrder(root);
        System.out.println(list);
    }


}
