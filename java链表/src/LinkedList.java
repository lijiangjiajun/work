class LinkedNode{
    public int data=0;
    public LinkedNode next=null;
    public LinkedNode(int data){
        this.data = data;
    }
}


public class LinkedList {
    private LinkedNode head = null ;

    public void HeadInsert(int elem){
        LinkedNode node  = new LinkedNode(elem);
        if(head==null){
            head = node;
        }
        else{
            node.next = head ;
            head = node;
        }
    }

    public void TailInsert(int elem){
        LinkedNode node = new LinkedNode(elem);
        LinkedNode cur = head;
        if(head ==null ){
            head = node;
        }

        else{
            while(cur.next!=null){
                cur= cur.next;
            }
            cur.next = node;
        }
    }

    public int size(){
        int size=0;
        LinkedNode cur = head;
        if(cur==null){
            return -1;
        }
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        return size;
    }

    public boolean Contain(int elem){
        LinkedNode cur = head;
        if(cur==null){
            return false;
        }
        while(cur.next!=null) {
            cur = cur.next;
            if (cur.data == elem) {
                return true;
            }
        }
        return false;
    }
  //删除第一个出现的元素
    public void ReMove(int elem){
        if(elem==head.data){
            head=head.next;
            return;
        }
        LinkedNode cur = getPos(elem);
          if(cur==null) {
              return;
          }
          else{
              cur.next = cur.next.next;
          }
    }
    //获取要删除元素的前一个位置
    public LinkedNode getPos(int elem){
        LinkedNode cur = head;
        if(head==null  ){
            return null;
        }
        while(cur.next!=null) {
            cur = cur.next;
            if (cur.next.data == elem) {
                return cur;
            }
        }
        return null;
    }

    public void show(){
        LinkedNode node ;
        for(node=head;node!=null;node=node.next){
            System.out.print(node.data+" ");
        }
    }
}
