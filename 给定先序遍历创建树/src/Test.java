
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        binary tree = new binary();
        while(scanner.hasNext()){
            String line = scanner.next();
            TreeNode root =  tree.buildTree(line);
            tree.inOrder(root);
        }

    }


}
