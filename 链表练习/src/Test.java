public class Test {
    public static void main(String[] args){
        LinkedList list = new LinkedList();

//        LinkedList list2= new LinkedList();
//        LinkedList list3= new LinkedList();
//        list.ReMoveVal(20);
//       LinkedNode newHead = list.reverse();
        list.TailInsert(10);

        list.TailInsert(30);
        list.TailInsert(30);
        list.TailInsert(30);
        list.TailInsert(40);
        list.TailInsert(50);
//        LinkedNode node = list.getHead();
//        LinkedNode  head = list.reverse(node);

      LinkedNode  node = list.repeatNode();

        list.showNew(node);
//        LinkedNode Head =  list.valSeq(70);
//          boolean bool =  list.chkPalindrome();
//        LinkedNode head2= list2.getHead();
//        LinkedNode head3= list3.getHead();
//        LinkedNode head =  list.combine(head2,head3);
//        System.out.println(bool);

    }


}
