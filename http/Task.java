package http;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;


public class Task implements Runnable{
    public Socket socket;
    public Task(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            Request request =Request.parse(is);
            System.out.println("请求: "+request);
            if(request.path.equals("/hello")){
                StringBuilder sb = new StringBuilder();
                String body = "<h1>你好</h1>";
                byte[] buffer = body.getBytes("UTF-8");
                sb.append("HTTP/1.0 200 OK\r\n");
                sb.append("Content-Type: text/plain;charset=UTF-8\r\n");
                sb.append("Content-Length: ");
                sb.append(buffer.length);
                sb.append("\r\n");
                sb.append("\r\n");
                sb.append(body);
                os.write(sb.toString().getBytes("UTF-8"));
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


//import java.io.*;
//import java.net.Socket;
//import java.text.SimpleDateFormat;
//
//public class Task implements Runnable {
//    private final Socket socket;
//
//    public Task(Socket socket) {
//        this.socket = socket;
//    }
//
//    @Override
//    public void run() {
//        try {
//            InputStream is = socket.getInputStream();
//            OutputStream os = socket.getOutputStream();
//            // 读取请求并解析
//            Request request = Request.parse(is);
//            System.out.println(request);
//            // 处理业务
//            if (request.path.equals("/hello")) {
//                String body = "<h1>你好</h1>";
//                byte[] bodyBytes = body.getBytes("UTF-8");
//
//                // 拼接响应并发送
//                StringBuilder responseSB = new StringBuilder();
//                responseSB.append("HTTP/1.0 200 OK\r\n");
//                responseSB.append("Content-Type: text/plain;charset=UTF-8\r\n");
//                responseSB.append("Content-Length: ");
//                responseSB.append(bodyBytes.length);
//                responseSB.append("\r\n");
//                responseSB.append("\r\n");
//                responseSB.append(body);
//                // 发送响应
//                os.write(responseSB.toString().getBytes("UTF-8"));
//                os.flush();
//            }
//        }
//         catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
