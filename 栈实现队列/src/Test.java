import java.util.Stack;

public class Test {
    static class MyQueue {

        @Override
        public String toString() {
            return "MyQueue{" +
                    "stackA=" + stackA +
                    ", stackB=" + stackB +
                    '}';
        }

        private  Stack stackA = new Stack();
        private  Stack stackB = new Stack();
        /** Push element x to the back of queue. */
        public void push(int x) {
            stackA.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stackA.size() == 0) {
                return 0;
            } else {
                while (stackA.size() > 1) {
                    stackB.push(stackA.pop());
                }
                int ret = (int) stackA.pop();
                while (!stackB.isEmpty()) {
                    stackA.push(stackB.pop());
                }
                return ret;
            }
        }

        /** Get the front element. */
        public int peek() {
            if(stackA.size()==0){
                return 0;
            }
            else{
                while(stackA.size()>1){
                    stackB.push(stackA.pop());
                }
                int ret = (int)stackA.pop();
                stackB.push(ret);
              while(!stackB.isEmpty()){
                  stackA.push(stackB.pop());
              }
                return ret;
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if(stackA.isEmpty()){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.peek());
        System.out.println(queue);
    }
}
