public class YieldDemo {
    static class MyThread1 extends Thread{
        String message;
        String name;
        MyThread1(String name,String message){
            super(name);
            this.message = message;
        }

        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    static class MyThread2 extends Thread{
        String message;
        String name;
        MyThread2(String name,String message){
            super(name);
            this.message = message;
        }

        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                yield();
            }
        }
    }

    public static void main(String[] args) {
        MyThread1 t1= new MyThread1("我的线程","哈哈");
        MyThread2 t2= new MyThread2("你的线程","嘻嘻");
        t2.start();
        t1.start();
    }
}
