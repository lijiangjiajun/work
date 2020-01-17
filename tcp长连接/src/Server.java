package tcp.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        // 监听 socket
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            // 双方的通信 socket
            System.out.println("等待 client 连接");
            Socket socket = serverSocket.accept();
            System.out.println("有 client 连接上来");

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(
                    new OutputStreamWriter(os, "UTF-8"),
                    false
            );

            Scanner scanner = new Scanner(is, "UTF-8");
            while (scanner.hasNext()) {
                String message = scanner.nextLine();
                System.out.println("收到对方的消息：" + message);
                String responseMessage = message;
                System.out.println("发给对方的消息：" + responseMessage);
                printWriter.println(responseMessage);
                printWriter.flush();
            }

            socket.close();
        }
    }
}
