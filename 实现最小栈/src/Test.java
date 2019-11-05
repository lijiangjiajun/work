public class Test {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-18);
        stack.push(-2);
        stack.push(-20);
        stack.push(20);
        System.out.println(stack.getMin());
        System.out.println(stack);
    }

}
