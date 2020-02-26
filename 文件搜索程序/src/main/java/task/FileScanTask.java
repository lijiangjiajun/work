//package task;
//
//import java.io.File;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class FileScanTask {
//
//    private static final ExecutorService POOL = Executors.newFixedThreadPool(4);
//
////    private static volatile int COUNT=0;
//
//    private final AtomicInteger count =new AtomicInteger(5);
//
//    private  final CountDownLatch latch = new CountDownLatch(1);
//
//    private FileScanCallback callback;
//
//    public FileScanTask(FileScanCallback fileScanCallback){
//        callback= fileScanCallback;
//    }
//
//    public  void startScan(File root) {
////        File root = new File("D:\\输入输出流测试文件");
//
////        synchronized (this){
////            COUNT++;
////        }
//        count.incrementAndGet();//自增
//        POOL.execute(new Runnable() {
//            @Override
//            public void run() {
//                list(root);
//            }
//        });
//    }
//
//    public void list(File dir){
//        if(!Thread.interrupted()) {
//            try {
////                System.out.println(dir.getPath());
//                callback.execute(dir);
//                if (dir.isDirectory()) {
//                    File[] children = dir.listFiles();
//                    if (children != null && children.length > 0) {
//                        for (File child : children) {
//                            if (child.isDirectory()) {
//                                count.incrementAndGet();//自增
//                                POOL.execute(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        list(child);
//                                    }
//                                });
//                            } else {
////                                System.out.println(child.getPath());
//                                callback.execute(child);
//                            }
//                        }
//                    }
//                }
//            } finally {
////            synchronized (this) {
////                COUNT--;
////                if(COUNT==0){
////                    System.out.println("0");
////                    this.notifyAll();
////                }
////            }
//                if (count.decrementAndGet() == 0) {
//                    //通知
//                    latch.countDown();
//                }
//            }
//
//        }
//    }
//
//
//    public void waitFinish() {
////        synchronized (this){
////            try {
////                this.wait();
////                System.out.println("等待线程结束");
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////        }
//        //等待
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            //中断所有线程
//            POOL.shutdown();//调用每个线程的interrupt()中断   interrupt()是修改标志位
////            POOL.shutdownNow();//调用线程的stop()关闭         stop()是强行关闭
//        }
//    }
//}


package task;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FileScanTask {

    private final ExecutorService pool
//            = new ThreadPoolExecutor();
            = Executors.newFixedThreadPool(4);

    //    private static volatile int COUNT;
    private final AtomicInteger count = new AtomicInteger();

    private final CountDownLatch latch = new CountDownLatch(1);

    private FileScanCallback callback;

    public FileScanTask(FileScanCallback callback) {
        this.callback = callback;
    }

    /**
     * 启动根目录的扫描任务
     *
     * @param root
     */
    public void startScan(File root) {
//        synchronized (this) {
//            COUNT++;
//        }
        count.incrementAndGet();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                list(root);
            }
        });
    }

    /**
     * 等待所有扫描任务执行完毕
     */
    public void waitFinish() throws InterruptedException {
//        try {
//            synchronized (this){
//                this.wait();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // 等待
        try {
            latch.await();
        } finally {
            pool.shutdown();// 调用每个线程的interrupt()中断
//            POOL.shutdownNow();// 调用每个线程的stop()关闭
        }
    }

    public void list(File dir) {
        if (!Thread.interrupted()) {
            try {
                callback.execute(dir);
//                System.out.println(dir.getPath());
                if (dir.isDirectory()) {
                    File[] children = dir.listFiles();
                    if (children != null && children.length > 0) {
                        for (File child : children) {
                            // 启动子线程执行子文件夹的扫描任务
                            if (child.isDirectory()) {
//                            synchronized (this) {
//                                COUNT++;
//                            }
                                count.incrementAndGet();
                                pool.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        list(child);
                                    }
                                });
                            } else {
                                callback.execute(child);
//                                System.out.println(child.getPath());
                            }
                        }
                    }
                }
            } finally {
//            synchronized (this) {
//                COUNT--;
//                if(COUNT == 0){
//                    // notify()
//                    this.notifyAll();
//                }
//            }
                // 所有线程执行完毕
                if (count.decrementAndGet() == 0) {
                    // 通知
                    latch.countDown();
                }
            }
        }
    }
}
