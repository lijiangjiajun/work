class DoubleLinkedNode{
    int data=0;
    DoubleLinkedNode next=null;
    DoubleLinkedNode prev=null;

    public DoubleLinkedNode(int data) {
        this.data = data;
    }



}

public class DoubleLinkedList {
    private DoubleLinkedNode head = new DoubleLinkedNode(-1);
    public void HeadInsert(int data){
        DoubleLinkedNode node = new DoubleLinkedNode(data);
        if(head.next==null) {
            head.next = node;
            node.prev = head;

            head.prev = node;
            node.next = head;
        }
        else {
            node.next = head.next;
            head.next.prev = node;
            head.next=node;
            node.prev = head;
        }
    }

    public void TailInsert(int data){
        DoubleLinkedNode node = new DoubleLinkedNode(data);
        if(head.next==null) {
            head.next = node;
            node.prev = head;

            head.prev = node;
            node.next = head;
        }

        else {
            node.prev = head.prev;
            head.prev.next = node;
            head.prev = node;
            node.next = head;
        }
    }

    public void show(){
        DoubleLinkedNode cur = head.next;
        System.out.println("正向遍历");
        for(;cur!=head;cur=cur.next){
            System.out.println(cur.data);
        }
        cur = head.prev;
        System.out.println("反向遍历");
        for(;cur!=head;cur=cur.prev){
            System.out.println(cur.data);
        }
    }

}
