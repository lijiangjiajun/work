class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class List {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node = headB;
        if(headB==null){
            return null;
        }
        while(headA!=null){
            while(headA!=node && node.next!=null){
                node=node.next;
            }
            if(node==headA)
            {
                return node;
            }
            headA=headA.next;
            node = headB;
        }
        return null;
    }
}
