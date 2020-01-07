public class ShowThread {
    public  static int n= 0;
    static class MyThread extends Thread{
        public void run(){
            for(int i=0;i<5000;i++){
                synchronized(ShowThread.class) {
                    n++;
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyThread[] thread = new MyThread[5];
        for(int i=0;i<5;i++){
            thread[i]=new MyThread();
            thread[i].start();
        }
//        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            thread[i].join();
        }
        System.out.println(n);
    }
}
