public class Test {
    public static void main(String[] args) {
        MyPriorityQueue queue =new MyPriorityQueue();
        queue.offer(3);
        queue.offer(5);
        queue.offer(6);
        queue.offer(2);
        queue.offer(1);
        while(queue.size>0){
            System.out.println(queue.poll());
        }
    }
}
