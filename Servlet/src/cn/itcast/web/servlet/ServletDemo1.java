package cn.itcast.web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo1...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

//init：方法在servlet创建时执行，只会执行一次。
//        service：每一次Servlet访问时被执行。
//        destroy：在servlet被杀死的时候执行（服务器正常关闭时执行）
//        getServletConfig：获取servlet的配置对象。
//        getServletInfo：获取servlet的一些信息，版本、作者等。