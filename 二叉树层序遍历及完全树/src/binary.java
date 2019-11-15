import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class binary {


    public  Node build() {
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

    public void level(Node root){
        if(root==null){
            return;
        }//循环left  right 存入队列中，并取队首元素；
        Queue<Node> queue =new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.val);
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }

        }
    }

    public boolean isComplete(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(!flag) {
                if (cur.left == null && cur.right != null) {
                    return false;
                }
                if (cur.left != null && cur.right == null) {
                    flag = true;
                    queue.offer(cur.left);
                }
                if (cur.left == null && cur.right == null) {
                    flag=true;
                } else {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            else{
                if(cur.left!=null || cur.right !=null){
                    return false;
                }
            }
        }
        return true;
    }
}
