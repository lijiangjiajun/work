package tcp.threadpool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static class Worker implements Runnable{

        Socket socket = new Socket();
        public Worker(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                Scanner scanner = new Scanner(is,"UTF-8");
                PrintStream printStream = new PrintStream(os,false,"UTF-8");
                while(scanner.hasNext()){
                    String message = scanner.nextLine();
                    System.out.println(name+" "+message);
                    String ret = message;
                    printStream.println(ret);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            System.out.println("等待连接");
            Socket socket = serverSocket.accept();
            System.out.println("连接成功");
            ExecutorService pool = Executors.newFixedThreadPool(10);
            pool.execute(new Worker(socket));
        }
    }
}

