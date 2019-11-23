import java.util.ArrayList;
import java.util.List;

class Node{
    public int val;
    public Node left;
    public Node right;

    public Node(int val){
        this.val =val;
    }
}

public class binary {
    public Node root = null;

    public Node build() {
        Node A = new Node(1);
        Node B = new Node(2);
        Node C = new Node(3);
        Node D = new Node(4);
        Node E = new Node(5);
        Node F = new Node(6);
        Node G = new Node(7);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;

        return A;
    }
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(Node root) {
        if(root==null){
            return result;
        }
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }

    public List<Integer> mid(Node root){
        if(root==null){
            return result;
        }
        mid(root.left);
        result.add(root.val);
        mid(root.right);
        return result;
    }

    public List<Integer> behind(Node root){
        if(root==null){
            return result;
        }
        behind(root.left);
        behind(root.right);
        result.add(root.val);
        return result;
    }
    public boolean isSameTree(Node root1,Node root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isSameTree(root1.left,root2.left) &&
                isSameTree(root1.right,root2.right);
    }







    @Override
    public String toString() {
        return "binary{" +
                "root=" + root +
                '}';
    }
}