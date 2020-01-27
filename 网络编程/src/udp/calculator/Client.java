package udp.calculator;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket();
        while(true){
            System.out.println("请输入要输入的内容");
            String message = scanner.next();
            byte[] send = message.getBytes("UTF-8");
            InetAddress address =InetAddress.getByAddress(new byte[] {(byte)192,
                    (byte)168,(byte)137,1});
            DatagramPacket sendpacket = new DatagramPacket(send,
                    0,send.length,address,8888);
            socket.send(sendpacket);
            byte[] receive = new byte[4096];
            DatagramPacket receivepacket = new DatagramPacket(receive,0,receive.length);
            socket.receive(receivepacket);
            String echomessage = new String(receive,0,receive.length,"UTF-8");
            System.out.println(echomessage);
        }
    }
}
