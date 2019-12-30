import javax.swing.text.html.HTMLDocument;

public class WatchThreadState {
    private static class MyThread extends Thread{
        public void run(){
            while(!Thread.interrupted()){

            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());
        myThread.start();
        System.out.println(myThread.getState());
        myThread.interrupt();//通知子线程停止
        while(myThread.isAlive()){//主线程一直占用CPU等主线程时间片用完了才让给子线程
            System.out.println(myThread.getState());
        }
        System.out.println(myThread.getState());
    }
}





