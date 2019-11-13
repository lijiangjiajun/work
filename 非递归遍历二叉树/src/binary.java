import java.util.Stack;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class binary {

    public void prev(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack =new Stack<>();
        stack.push(root);
        while(true){
            if(stack.isEmpty()){
                break;
            }
            Node ret = stack.pop();
            System.out.println(ret.val);

            if(ret.right!=null){
                stack.push(ret.right);
            }
            if(ret.left!=null){
                stack.push(ret.left);
            }

        }
    }


    public void mid(Node root){
        if(root==null){
            return ;
        }
        Stack<Node> stack =new Stack<>();
        Node cur = root;
        while(true){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            Node ret =  stack.pop();
            System.out.println(ret.val);
            cur=ret.right;
        }
    }

    public void post(Node root){
        if(root==null){
            return ;
        }
        Stack<Node> stack = new Stack<>();
        Node cur=root;
        Node prev = null;
        while(true){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            Node ret = stack.peek();
            if(ret.right==null || prev ==ret.right){
                System.out.println(ret.val);
                stack.pop();
                prev = ret;
            }
            else{
                cur = ret.right;
            }

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
