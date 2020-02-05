package cn.itcast.web.servlet.cn.itcast.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContext4")
public class Context4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        /*获取服务器路径*/
        String path = context.getRealPath("/b.txt");/*web目录下的资源访问  /+文件名即可  */
        File file = new File(path);
        System.out.println(path);

        String c =  context.getRealPath("/WEB-INF/c.txt");/*WEB-INF下的资源访问*/
        System.out.println(c);

        String a  = context.getRealPath("/WEB-INF.classes/a.txt");
        System.out.println(a);
    }
}
