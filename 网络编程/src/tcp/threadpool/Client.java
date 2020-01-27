package tcp.threadpool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        Scanner tcpscanner = new Scanner(is,"UTF-8");
        while(true){
            System.out.println("请输入内容");
            String send = scanner.nextLine();
            send= send+"\r\n";
            byte[] buffer = send.getBytes("UTF-8");
            os.write(buffer);
            String message = tcpscanner.nextLine();
            System.out.print("接收得内容为 ");
            System.out.println(message);
        }
    }
}

