public class CreateThread {
 private static final long count = 1_0000_0000L;
 private static class MyThread extends Thread{
     public void run(){
         long r =0;
         for(int i=0;i<count;i++){
             r+=(i*i);
         }
         System.out.println(r);
     }
 }

 private static class MyRunnable implements Runnable{


     @Override
     public void run() {
         long r =0;
         for(int i=0;i<count;i++){
             r+=(i*i);

         }
         System.out.println(r);
     }
     }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyRunnable myRunnable = new MyRunnable();
        myThread.start();

        Thread thread = new Thread(myRunnable);
        thread.start();

        Thread thread1 = new Thread(myThread);
        thread1.start();
    }

}
