package frank.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession(false);//获取一个session，如果没有就返回null
        if (session!=null) {
            Object user = session.getAttribute("user");
            if(user!=null) {
                return true;
            }
        }
        response.sendRedirect("/login");
        return false;
    }
}


