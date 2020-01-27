package udp.calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {

    public static String parse(String message){
        String[] str =  message.split(" ");
        int a= Integer.parseInt(str[0]);
        int b= Integer.parseInt((str[2]));
        int ret=0;
        switch(str[1]){
            case "+": ret = a+b;
            break;
            case "-": ret = a-b;
            break;
            case "*": ret =a*b;
            break;
            case "/": ret = a/b;
            break;
            default: ret = -1;
        }
        return ret+"";
    }

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        while(true){
            byte[] buffer = new byte[4096];
            DatagramPacket receivepacket = new DatagramPacket(buffer,0,buffer.length);
            int len = receivepacket.getLength();
            socket.receive(receivepacket);
            String message = new String(buffer,0,len,"UTF-8");
            System.out.println("收到了消息"+message);
            String ret = parse(message);
            byte[] send = ret.getBytes("UTF-8");
            DatagramPacket sendpacket = new DatagramPacket(
                    send,
                    0,
                    len,
                    receivepacket.getAddress(),
                    receivepacket.getPort()
                    );
            socket.send(sendpacket);
            System.out.println("发送的消息"+"ret");
        }

    }
}
