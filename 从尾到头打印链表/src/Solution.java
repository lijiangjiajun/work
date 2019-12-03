import java.util.ArrayList;

class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
            this.val = val;
         }
     }



public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode prev = null;
        ListNode cur = listNode;
        ListNode curN = listNode;
        ListNode newhead=null;
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode==null){
            return list;
        }
        while(cur!=null){
            if(cur.next==null){
                newhead =cur;
            }
            curN=cur.next;
            cur.next=prev;
            prev = cur;
            cur=curN;

        }
        for(;newhead!=null;newhead=newhead.next){
            list.add(newhead.val);
        }
        return list;
    }
}