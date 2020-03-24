package frank.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                         Object handler) throws Exception {
if (request.getSession().getAttribute("user") == null) {
request.getSession().setAttribute("from", request.getRequestURI());
response.sendRedirect("/login.html");   //拦截后跳转到login.html
return false;
}
return true;
}
}