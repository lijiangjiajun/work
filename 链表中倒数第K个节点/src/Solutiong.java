/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solutiong {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null){
            return null;
        }
        if(k<=0){
            return null;
        }
        ListNode cur = head;
        int count=0;
        for(;cur!=null;cur=cur.next){
            count++;
        }
        if(count<k){
            return null;
        }
        cur=head;
        for(int i=0;i<count-k;i++){
            cur=cur.next;
        }
        return cur;
    }
}