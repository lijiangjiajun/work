import java.util.HashMap;

class DLinkedNode {
    int key;    //通过key在hashmap中查找链表的节点
    int value;   //这是链表节点的值
    DLinkedNode pre;
    DLinkedNode post;
}

    /**
     * 总是在头节点中插入新节点.
     */
    public class LRUCache {
        private void addNode(DLinkedNode node) {

            node.pre = head;
            node.post = head.post;

            head.post.pre = node;
            head.post = node;
        }

        /**
         * 摘除一个节点.
         */
        private void removeNode(DLinkedNode node) {
            DLinkedNode pre = node.pre;
            DLinkedNode post = node.post;

            pre.post = post;
            post.pre = pre;
        }

        /**
         * 摘除一个节点,并且将它移动到开头
         */
        private void moveToHead(DLinkedNode node) {
            this.removeNode(node);
            this.addNode(node);
        }

        /**
         * 弹出最尾巴节点
         */
        private DLinkedNode popTail() {
            DLinkedNode res = tail.pre;
            this.removeNode(res);
            return res;
        }

        private HashMap<Integer, DLinkedNode>
                cache = new HashMap<Integer, DLinkedNode>();
        private int count;
        private int capacity;
        private DLinkedNode head, tail;

        //构造方法
        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            head.pre = null;

            tail = new DLinkedNode();
            tail.post = null;

            head.post = tail;
            tail.pre = head;
        }

        public int get(int key) {

            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1; // cache 里面没有
            }

            // cache 命中,挪到开头
            this.moveToHead(node);

            return node.value;
        }


        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if (node == null) {

                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                this.cache.put(key, newNode);
                this.addNode(newNode);

                ++count;

                if (count > capacity) {
                    // 最后一个节点弹出
                    DLinkedNode tail = this.popTail();
                    this.cache.remove(tail.key);
                    count--;
                }
            } else {
                // cache 命中,更新 cache.
                node.value = value;
                this.moveToHead(node);
            }
        }
    }
