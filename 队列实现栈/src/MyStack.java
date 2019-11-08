import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue queueA =new LinkedList();
    private Queue queueB = new LinkedList();
    private int size=0;
    /** Push element x onto stack. */
    public void push(int x) {
       queueA.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queueA.isEmpty()){
            return 0;
        }
        while(queueA.size()>1){
            queueB.add(queueA.remove());
        }
        int ret = (int) queueA.poll();
        Queue tmp =queueA;
        queueA=queueB;
        queueB=tmp;
        return ret;

    }

    /** Get the top element. */
    public int top() {
        if(queueA.isEmpty()){
            return 0;
        }
        while(queueA.size()>1){
            queueB.add(queueA.remove());
        }
        int ret = (int) queueA.peek();
        queueB.add(queueA.remove());
        Queue tmp =queueA;
        queueA=queueB;
        queueB=tmp;
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queueA.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}