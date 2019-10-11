public class Test {
    public static void main(String[] args){
//        DoubleLinkedList list = new DoubleLinkedList();
//        list.TailInsert(1);
//        list.TailInsert(2);
//        list.TailInsert(3);
//        list.TailInsert(5);
//        list.show();
      LinkedList list1 = new LinkedList();
        list1.TailInsert(9);

        ListNode head1= list1.get();
        LinkedList list2 = new LinkedList();
        list2.TailInsert(1);
        list2.TailInsert(9);
        list2.TailInsert(9);
        list2.TailInsert(9);
        list2.TailInsert(9);
        list2.TailInsert(9);
        list2.TailInsert(9);
        list2.TailInsert(9);
        list2.TailInsert(9);
//        list2.TailInsert(9);
        ListNode head2 = list2.get();
        LinkedList list = new LinkedList();
        ListNode head =  list.addTwoNumbers(head1,head2);
        list.show(head);
    }
}
