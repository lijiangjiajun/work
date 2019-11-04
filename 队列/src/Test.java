public class Test {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());
      queue.show();
    }
}
