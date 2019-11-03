public class Test {
    public static void main(String[] args) {
        Mystack mystack = new Mystack();
        System.out.println(mystack.isempty());

        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        mystack.pop();
        System.out.println(mystack.peek());
        mystack.show();
    }
}
