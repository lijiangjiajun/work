public class Test {
    public static void main(String[] args){
        TestHeadInsert();
    }
    public static void TestHeadInsert(){
        LinkedList list = new LinkedList();
        list.TailInsert(1);
        list.TailInsert(2);
        list.TailInsert(2);
        list.TailInsert(4);
        list.ReMove(1);
        list.show();
    }
}
