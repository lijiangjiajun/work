import java.util.HashMap;
import java.util.Map;

public class Test {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        for(Node cur =head;cur!=null;cur=cur.next){
            map.put(cur,new Node(cur.val,null,null));
        }
        for(Node cur =head;cur!=null;cur=cur.next){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }

}
