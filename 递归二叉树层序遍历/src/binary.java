import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node  left;
    public Node right;
    public Node (int val){
        this.val=val;
    }
}

public class binary {
    List<List<Integer>> result = new ArrayList<>();
    int level =0;
    public List<List<Integer>> levelOrder(Node root){
        if(root==null){
            return null;
        }
        helper(root,0);
        return result;
    }

    public void helper(Node root,int level){
            if(root==null){
                return;
            }
            if(result.size()==level){
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            if(root.left!=null){
                helper(root.left,level+1);
            }
            if(root.right!=null){
                helper(root.right,level+1);
            }

    }

    public  Node buildTree() {
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
}
