package http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer  {
    public static List<User> users = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(8888);
        ExecutorService pool = Executors.newFixedThreadPool(20);
        while(true){
            System.out.println("等待客户端连接");
            Socket socket = serversocket.accept();
            System.out.println("连接成功");
            pool.execute(new Task(socket));
        }
    }

    public static void add(){
        users.add(new User("1","peixinchen", "https://marketplace.canva.cn/EADcCC1MEjA/1/0/800w/canva-%E6%A9%99%E8%93%9D%E8%89%B2%E7%85%A7%E7%89%87%E4%B8%AA%E4%BA%BA%E5%88%86%E4%BA%AB%E5%BE%AE%E4%BF%A1%E5%A4%B4%E5%83%8F-Z6ykgeX5Pr4.jpg", "懒得说"));
        users.add(new User("2","bogao", "https://marketplace.canva.cn/EADcCC1MEjA/1/0/800w/canva-%E6%A9%99%E8%93%9D%E8%89%B2%E7%85%A7%E7%89%87%E4%B8%AA%E4%BA%BA%E5%88%86%E4%BA%AB%E5%BE%AE%E4%BF%A1%E5%A4%B4%E5%83%8F-Z6ykgeX5Pr4.jpg", "懒得说"));
        users.add(new User("3","gaobo", "https://marketplace.canva.cn/EADcCC1MEjA/1/0/800w/canva-%E6%A9%99%E8%93%9D%E8%89%B2%E7%85%A7%E7%89%87%E4%B8%AA%E4%BA%BA%E5%88%86%E4%BA%AB%E5%BE%AE%E4%BF%A1%E5%A4%B4%E5%83%8F-Z6ykgeX5Pr4.jpg", "懒得说"));
        users.add(new User("5","chenpeixin", "https://marketplace.canva.cn/EADcCC1MEjA/1/0/800w/canva-%E6%A9%99%E8%93%9D%E8%89%B2%E7%85%A7%E7%89%87%E4%B8%AA%E4%BA%BA%E5%88%86%E4%BA%AB%E5%BE%AE%E4%BF%A1%E5%A4%B4%E5%83%8F-Z6ykgeX5Pr4.jpg", "懒得说"));
    }
}
