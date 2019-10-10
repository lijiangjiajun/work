/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 /
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode  cur = iscircle(head);
        if(cur ==null  ){
            return null;
        }
        else{
            ListNode node = head;
            while(node!=cur){
                node=node.next;
                cur=cur.next;
            }
        }
        return cur;
    }
    
    public ListNode iscircle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow == fast){
                return slow;
            }
            
        }
        return null;
    }
}