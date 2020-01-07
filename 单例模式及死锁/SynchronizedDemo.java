class SomeObject{

}

public class SynchronizedDemo {
    public synchronized static void staticMethod(){

    }

    public synchronized void Method(){

    }

    public void someMethod(){
        synchronized(this){

        }
    }

    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o){

        }

        synchronized (SomeObject.class){

        }

        Class cls1 =SomeObject.class;
        SomeObject someObject = new SomeObject();
        Class<?> cls2 = someObject.getClass();
        System.out.println(cls1 == cls2);
    }
}
