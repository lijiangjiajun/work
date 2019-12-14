/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode node = new ListNode(-1);
        ListNode newHead = node;
        ListNode cur = pHead;
        int flag=1;
        while( cur!=null){
            while(cur.next!=null && cur.val==cur.next.val){
                cur=cur.next;
                flag=0;
            }
            if(cur.next==null && flag==0){
                return newHead.next;
            }
            if(cur.next!=null && flag==0){
                cur=cur.next;
            }

            if(flag==1){
                node.next = new ListNode(cur.val);
                node=node.next;
                cur=cur.next;
            }
            flag=1;

        }
        return newHead.next;
    }
}