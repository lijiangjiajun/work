import javax.print.DocFlavor;

class Node{
    public int data=0;
    public Node next=null;
    public Node(int data){
        this.data = data;
    }
}

public class MyQueue {
    private Node head = null;
    private Node Tail = null;
    private int size =0;

    public void offer(int val){
        if(head == null){
            head = new Node(val);
            Tail=head;
            size++;
            return;
        }
        Tail.next=new Node(val);
        Tail=Tail.next;
        size++;
    }

    public Integer poll(){
        if(head == null){
            System.out.println("不好意思队列是空的");
            return null;
        }
        else{
            int ret = head.data;
            head=head.next;
            size--;
            return ret;
        }
    }

    public Integer peek(){
        if(head == null){
            System.out.println("不好意思队列是空的");
            return null;
        }
        else{
            int ret = head.data;
            return ret;
        }
    }

    public void show(){
        Node node =head;
        for(int i=0;i<size;i++){
            System.out.println(node.data);
            node = node.next;
        }
    }
}
