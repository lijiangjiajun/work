class MyThread extends Thread{

  public void run(){
      int a = 0;
      for(int i=0;i<1000;i++){
          a=a+1;
      }
      System.out.println(a);
  }
}

class MyRunnable implements Runnable{
    public void run(){
        int a = 0;
        for(int i=0;i<10000;i++){
            a+=1;
        }
        System.out.println(a);
    }
}

public class CreateThread {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start();

        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();
    }

}
