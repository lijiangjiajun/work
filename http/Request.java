package http;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
     String method ;
     String path;
     String version;
     HashMap<String,String> headers=new HashMap<>();

    public static Request parse(InputStream is){
        Request request = new Request();
        Scanner scanner = new Scanner(is,"UTF-8");
        String head = scanner.nextLine();
        String[] str = head.split(" ");
        request.method = str[0];
        request.path = str[1];
        request.version = str[2];
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            String[] kv = line.split(":");
            String key = kv[0].trim();
            String value = kv[1].trim();
            request.headers.put(key, value);
        }
        return request;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                '}';
    }
}



