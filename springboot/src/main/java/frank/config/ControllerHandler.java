package frank.config;

import frank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;

//有异常返回到static包下的error.html
@ControllerAdvice   //把当前类注入到容器中
public class ControllerHandler {

    @Autowired
    private User user1;

    //返回一个json格式的数据
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public User handle(Exception e){
//        return user1;
//    }

    @ExceptionHandler(Exception.class)//Controller类所接收得所有http请求，
    // 在方法中出现异常会调用本类
    public ModelAndView handle(Exception e) {      //返回一个页面
        ModelAndView mv=new ModelAndView();
        //添加属性到页面：异常信息
        mv.addObject("message",e.getMessage());
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        //添加异常的堆栈信息
        mv.addObject("stackTrace",sw);
        mv.setViewName("/error");
        return mv;
    }
}
