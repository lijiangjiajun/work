import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class NIO {
    static ByteBuffer byteBuffer = ByteBuffer.allocate(512);
    static List<SocketChannel> channelList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket =  ServerSocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1",9098);
        serverSocket.bind(socketAddress);
        serverSocket.configureBlocking(false);
        while (true){
            for(SocketChannel socketChannel : channelList){
                int read = socketChannel.read(byteBuffer);
                if(read>0){
                    System.out.println("read "+read);
                    byteBuffer.flip();
                    byte[] bs = new byte[read];
                    byteBuffer.get(bs);
                    String content = new String(bs);
                    System.out.println(content);
                    byteBuffer.flip();
                }
                else if(read==-1){
                    channelList.remove(channelList.indexOf(socketChannel));
                }
            }
            SocketChannel accept = serverSocket.accept();
            if(accept!=null){
                System.out.println("conn sucess");
                accept.configureBlocking(false);
                channelList.add(accept);
                System.out.println(channelList.size()+"list---size");
            }
        }
    }
}
