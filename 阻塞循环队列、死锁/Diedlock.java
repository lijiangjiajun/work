public class Diedlock {
    private static Object aLock = new Object();
    private static Object bLock = new Object();
    public static  class MyThread1 extends Thread  {

        public void run() {
            synchronized ("A"){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized ("B"){
                    System.out.println("A出发");
                }

            }
        }
    }

    public static class MyThread2 extends Thread{
        public void run(){
            synchronized("B"){
                synchronized ("A"){
                    System.out.println("B出发");
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread1 t1=new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}

