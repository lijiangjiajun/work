public class HowThreadDie2 {
    public static class Worker extends Thread{
        public void run(){
            while(!Thread.interrupted()){
                System.out.println("我正在挖煤");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Worker worker = new Worker();
            worker.start();
            Thread.sleep(1000);
            System.out.println("老婆生了，赶紧回来");
            worker.interrupt();
            worker.join();
            System.out.println("回来啦");

        }
    }
}
