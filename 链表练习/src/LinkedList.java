class LinkedNode{
    int data=0;
    LinkedNode next=null;
    public LinkedNode(int data){
        this.data=data;
    }
}

public class LinkedList {
    private LinkedNode head = null;

    public LinkedNode getHead() {
        return head;
    }

    public void HeadInsert(int data) {
        LinkedNode node = new LinkedNode(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void display() {
        LinkedNode node1 = middleNode();
        LinkedNode node2 = NodeK(1);
        System.out.println(node1.data);
        System.out.println(node2.data);
    }

    public void TailInsert(int data) {
        LinkedNode node = new LinkedNode(data);
        if (head == null) {
            head = node;
        } else {
            LinkedNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void show() {
        LinkedNode node = head;
        for (; node != null; node = node.next) {
            System.out.println(node.data);
        }
    }

    public LinkedNode middleNode() {
        LinkedNode fast = head;
        LinkedNode slow = head;
        if (head == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public LinkedNode NodeK(int k) {
        if (head == null) {
            return null;
        } else {
            LinkedNode fast = head;
            LinkedNode slow = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }


    public int size(LinkedNode head) {
        int size = 0;
        for (LinkedNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public LinkedNode reverse(LinkedNode Head) {
        LinkedNode cur = Head;
        LinkedNode prev = null;
        LinkedNode curN = Head;
        LinkedNode newHead = null;
        if (Head == null) {
            return null;
        }
        if (Head.next == null) {
            return Head;
        } else {
            while (curN != null) {

                curN = cur.next;
                if (curN == null) {
                    newHead = cur;
                }
                cur.next = prev;
                prev = cur;
                cur = curN;

            }
        }
        return newHead;
    }

    public void showNew(LinkedNode newHead) {
        LinkedNode node = newHead;
        for (; node != null; node = node.next) {
            System.out.println(node.data);
        }
    }

    public void ReMoveVal(int val) {
        LinkedNode node = head;
        while (node.data == val) {
            node = node.next;
        }
        if (head == null) {
            return;
        } else {
            while (node.next != null) {
                if (node.next.data == val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
        }
    }

    public LinkedNode combine(LinkedNode head1, LinkedNode head2) {

        LinkedNode NodeHead = null;
        LinkedNode NodeTail = null;

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {

                if (NodeTail == null) {
                    NodeHead = head1;
                    NodeTail = head1;
                    head1 = head1.next;
                } else {
                    NodeTail.next = new LinkedNode(head1.data);
                    NodeTail = NodeTail.next;
                    head1 = head1.next;
                }
            } else {
                if (NodeTail == null) {
                    NodeHead = head2;
                    NodeTail = head2;
                    head2 = head2.next;
                } else {
                    NodeTail.next = new LinkedNode(head2.data);
                    NodeTail = NodeTail.next;
                    head2 = head2.next;
                }
            }
        }
        if (head1 == null) {
            NodeTail.next = head2;
        }
        if (head2 == null) {
            NodeTail.next = head1;
        }
        return NodeHead;
    }

    public LinkedNode valSeq(int val) {
        LinkedNode cur = head;
        LinkedNode nodeHead1 = null;
        LinkedNode nodeHead2 = null;
        LinkedNode nodeTail1 = null;
        LinkedNode nodeTail2 = null;
//        LinkedNode nodeTail1prev=null;
//        LinkedNode nodeTail2prev=null;
        for(;cur!=null;cur=cur.next){
            if (cur.data < val || cur.data == val) {
                if (nodeHead1 == null) {
                    nodeHead1 = cur;
                    nodeTail1 = cur;

                } else {
                    nodeTail1.next = cur;
//                    nodeTail1prev=nodeTail1;
                    nodeTail1 = nodeTail1.next;
                }
            } else {
                if (nodeHead2 == null) {
                    nodeHead2 = cur;
                    nodeTail2 = cur;

                } else {
                    nodeTail2.next = cur;
//                    nodeTail2prev=nodeTail2;
                    nodeTail2 = nodeTail2.next;
                }
            }
            if(cur.next==null && nodeHead2!=null){
                nodeTail2.next=null;
            }

        }
        if(nodeHead2!=null) {
            nodeTail1.next=nodeHead2;
        }
        else{
            nodeTail1.next=null;
        }
        return nodeHead1;
    }

    public LinkedNode repeatNode() {
        int flag = 0;
        if (head == null) {
            return null;
        }
        while (head.data == head.next.data) {
            head = head.next;
            flag = 1;
        }
        if (flag == 1) {
            head = head.next;
        }
        LinkedNode prev=head;
        LinkedNode node = head;
        flag=0;
        while (node.next != null) {

            while ( node.next!=null && node.data == node.next.data ) {
                node.next = node.next.next;
                flag=1;
            }
            if(node.next!=null &&flag==1) {
                node = node.next;
                prev.next=node;
            }
            else if(node.next==null && flag==1){
                prev.next=node.next;
            }

            flag=0;
            prev=node;
            if(node.next!=null) {
                node = node.next;
            }
        }
        return head;
    }

    public boolean chkPalindrome(){
        if(head==null){
            return true;
        }
        if(head.next==null){
            return true;
        }
        LinkedNode pCur=head;
        LinkedNode node=middleNode();

        LinkedNode cur  = reverse(node);
        while(cur!=null){
            if(pCur.data!=cur.data ){
                return false;
            }
            cur=cur.next;
            pCur=pCur.next;
        }
        return true;
    }



}

