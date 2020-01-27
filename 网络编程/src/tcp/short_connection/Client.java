package tcp.short_connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while(true){
            Socket socket =new Socket("127.0.0.1",8888);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("请输入要发送得消息");
            String message =scanner.next();
            message = message+"\r\n";
            outputStream.write(message.getBytes("UTF-8"));
            Scanner tcpscanner = new Scanner(inputStream,"UTF-8");
            String ret = tcpscanner.next();
            System.out.println("接收得消息是"+ret);
            socket.close();
        }
    }
}
