package tcp.short_connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket =new ServerSocket(8888);
        while(true){
            System.out.println("等待连接");
            Socket socket =serverSocket.accept();
            System.out.println("连接成功");
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            Scanner scanner = new Scanner(is,"UTF-8");
            System.out.println("等待对方输入");
                String message = scanner.next();
                System.out.println("对方输入得是"+message);
                String send = message;
                byte[] buffer = send.getBytes("UTF-8");
                os.write(buffer,0,buffer.length);
                socket.close();

            }
        }
    }

