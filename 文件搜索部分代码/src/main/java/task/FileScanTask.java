package task;

import java.io.File;
import java.lang.invoke.LambdaConversionException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class FileScanTask {

    private static final ExecutorService POOL = Executors.newFixedThreadPool(4);

//    private static volatile int COUNT=0;

    private static AtomicInteger COUNT=new AtomicInteger(5);

    private static final CountDownLatch LATCH = new CountDownLatch(1);

    private FileScanCallback callback;

    public FileScanTask(FileScanCallback fileScanCallback){
        callback= fileScanCallback;
    }

    public  void startScan(File root) {
//        File root = new File("D:\\输入输出流测试文件");

//        synchronized (this){
//            COUNT++;
//        }
        COUNT.incrementAndGet();//自增
        POOL.execute(new Runnable() {
            @Override
            public void run() {
                list(root);
            }
        });
    }

    public void list(File dir){
        if(!Thread.interrupted()) {
            try {
//                System.out.println(dir.getPath());
                callback.execute(dir);
                if (dir.isDirectory()) {
                    File[] children = dir.listFiles();
                    if (children != null && children.length > 0) {
                        for (File child : children) {
                            if (child.isDirectory()) {
                                COUNT.incrementAndGet();//自增
                                POOL.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        list(child);
                                    }
                                });
                            } else {
//                                System.out.println(child.getPath());
                                callback.execute(child);
                            }
                        }
                    }
                }
            } finally {
//            synchronized (this) {
//                COUNT--;
//                if(COUNT==0){
//                    System.out.println("0");
//                    this.notifyAll();
//                }
//            }
                if (COUNT.decrementAndGet() == 0) {
                    //通知
                    LATCH.countDown();
                }
            }

        }
    }


    public void waitFinish() {
//        synchronized (this){
//            try {
//                this.wait();
//                System.out.println("等待线程结束");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        //等待
        try {
            LATCH.await();
        } catch (InterruptedException e) {
            //中断所有线程
            POOL.shutdown();//调用每个线程的interrupt()中断   interrupt()是修改标志位
//            POOL.shutdownNow();//调用线程的stop()关闭         stop()是强行关闭
        }
    }
}
