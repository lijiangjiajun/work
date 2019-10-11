

   class ListNode {
      int val;
      ListNode next;
    ListNode(int x) { val = x; }
  }


   class LinkedList {

       public ListNode head = null;
       public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

           ListNode node1= l1;
           ListNode node2 = l2;
           int sum1=0;
           int sum2=0;
           int sum=0;
           int count=0;
           int i =1;
           for(;node1!=null;node1=node1.next){
               sum1=sum1+(node1.val)*i;
               i=i*10;
           }
           i=1;
           for(;node2!=null;node2=node2.next){
               sum2=sum2+node2.val*i;
               i=i*10;
           }

           sum=sum1+sum2;
           int tmp=sum;
           while(tmp!=0){
               tmp=tmp/10;
               count++;
           }
           int j=0;
           if(count==0){
               count++;
           }
           int[] arr = new int[count];
           while(sum!=0){
               arr[j]=sum%10;
               j++;
               sum=sum/10;
           }
           for(int k=0;k<arr.length;k++){
               TailInsert(arr[k]);
           }
           return head;

       }

       public void TailInsert(int val){
           ListNode node = new ListNode(val);
           if(head==null){
               head = node;
           }
           else{
               ListNode cur=head;
               ListNode last=null;
               while(cur.next!=null){
                   cur=cur.next;
               }
               cur.next = node;
           }
       }


    public  ListNode get(){
        return head;

    }

    public void show(ListNode head){
           ListNode node = head;
           for(;node!=null;node=node.next){
               System.out.println(node.val);
           }
    }




   }