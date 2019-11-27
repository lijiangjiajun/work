class Node{
    int key;
    int val;
    Node left;
    Node right;

    public Node(int key,int val) {
        this.key = key;
        this.val=val;
    }
}

public class Tree {
    private Node root=null;

    public Node build(){
        Node A = new Node(20,0);
        Node B = new Node(13,0);
        Node C = new Node(23,0);
        Node D = new Node(21,0);
        Node E = new Node(25,0);
        A.left = B;
        A.right = C;
        C.left = D;
        C.right = E;
        return A;

    }

    public void prev (Node root){
        if(root==null){
            return;
        }
        System.out.println(root.key);
        prev(root.left);
        prev(root.right);
    }

    public Node[] find(int num,Node root){
        Node cur =root;
        Node parent=null;
        Node[] node=new Node[2];
        while (cur!=null){
            if(cur.key==num){
                node[0]=cur;
                node[1]=parent;
                return node;
            }
            else if(num<cur.key){
                parent=cur;
                cur=cur.left;
            }
            else {
                parent=cur;
                cur=cur.right;
            }
        }
            return null;
    }

    public void insert(int key,int val,Node root){
        Node cur = root;
        Node parent = null;
        while (cur!=null){
            if(cur.key==key){
                System.out.println("插入失败");
                return;
            }
            else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }
            else {
                parent=cur;
                cur=cur.right;
            }
        }
        if(key<parent.key){
            parent.left=new Node (key,val);
        }
        else{
            parent.right = new Node (key,val);
        }

    }

    public boolean remove(int key ,Node root){  //这个数组第一个元素是cur
        //这个数组第一个元素是cur
        //第二个元素是cur的父节点
       Node[] cur = find(key,root);
       if(cur==null){
           return false;
       }
       if(cur[0].left==null){
           if(cur[0]==root){
               root=cur[0].right;
           }
           else if(cur[0]==cur[1].left){
               cur[1].left=cur[0].right;
           }
           else{
               cur[1].right = cur[0].right;
           }
       }
       else if(cur[0].right==null){
           if(cur[0]==root){
               root=cur[0].left;
           }
           else if(cur[0]==cur[1].left){
               cur[1].left=cur[0].left;
           }
           else{
               cur[1].right = cur[0].left;
           }
       }
       else{
           //左右子树都存在
        Node parent = cur[0];
        Node delete = cur[0].right;
        while(delete.left!=null){
            parent=delete;
            delete=delete.left;
        }
        cur[0].key=delete.key;
        cur[0].val=delete.val;
        if(delete==cur[0].right){
            cur[0].right=delete.right;
        }

        if(delete==parent.left){
            parent.left=delete.right;
        }
       }
       return true;
    }
}
