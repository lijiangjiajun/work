import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/requestDemo5")
public class requestDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post获取请求参数
        //不论get还是post都可以使用下列方法请求参数
//     String username= request.getParameter("username");
//        System.out.println("post");
//        System.out.println(username);


//        String[] hobbies = request.getParameterValues("hobby");
//        for(String hobby:hobbies){
//            System.out.println(hobby);
//        }

//        Enumeration<String> names = request.getParameterNames();
//        while(names.hasMoreElements()){
//            String name=names.nextElement();
//            System.out.println(name);
//            String value = request.getParameter(name);
//            System.out.println(value);
//    }


        //获取所有参数集合
        Map<String, String[]> map = request.getParameterMap();


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
