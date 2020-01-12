public class HowThreadDie {
    public static class Worker extends Thread{
        public boolean running = true;
        public void run(){
            while(running){
                System.out.println("我在挖煤");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void quit(){
            running = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(1000);
        System.out.println("老婆生了赶紧回家");
        worker.quit();
        worker.join();
        System.out.println("到家了");
    }
}
