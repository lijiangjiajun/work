import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo2")
public class requestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有请求头名称
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()){
//            String name = headerNames.nextElement();
//            //根据名称获取请求头的值
//            String value = request.getHeader(name);
//            System.out.println(name+":" +value);
//        }

        String agent = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if(agent.contains("Chrome")){
            System.out.println("谷歌");
        }else if(agent.contains("FireFox")){
            System.out.println("火狐");
        }












    }
}
