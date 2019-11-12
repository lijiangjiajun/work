class Node{
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class binary {
    Node lca=null;
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null){
            return null;
        }
        find(root,p,q);
        return lca;
    }

    public boolean find(Node root,Node p ,Node q){
        if(root==null){
            return false;
        }
        int left = find(root.left,p,q)?1:0;
        int right =find(root.right,p,q)?1:0;
        int mid=0;
        if(root==p || root==q){
            mid=1;
        }
        if(left+right+mid>=2){
            lca=root;
        }
        return left+right+mid>0;
    }

    public static Node buildTree() {
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
