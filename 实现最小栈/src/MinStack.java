import java.util.Stack;

class MinStack {


    public Stack<Integer> stackA = new Stack<>();
    public Stack<Integer> stackB = new Stack<>();


    public void push(int x) {

        if(stackA.size()==0){

            stackA.push(x);
            stackB.push(x);
            return;
        }
        stackA.push(x);
        int min=stackB.peek();
        if(x<min){
            min=x;
            stackB.push(min);
        }
        else{
            stackB.push(min);
        }
    }

    public void pop() {
        if(stackA.isEmpty()){
            return;
        }
        stackA.pop();
        stackB.pop();
    }

    public int top() {
        int ret = stackA.peek();
        return ret;
    }

    public int getMin() {
        return stackB.peek();
    }
}
