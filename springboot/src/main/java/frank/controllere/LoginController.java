package frank.controllere;

import frank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private User user1;

    @Autowired
    private User user2;

    @RequestMapping("/l1")
    @ResponseBody    //有ResponseBody会默认返回Content-Type:application/json
    public User l1(User user){
//        User user = new User();
//        user.setId(1);
//        user.setUsername("张三换李四");
//        user.setNickname("隔壁老王");
//        user.setEmail("xxx@qq.com");
//        user.setBirthday(new Date());
//        return user;
        if("a".equals(user.getUsername())) {
            return user1;
        }
        else{
            return user2;
        }
    }

//没有ResponseBody代表返回一个客户端的url
    @RequestMapping("/l2")
    public String l2(){
        return "/login.html";
    }

    @RequestMapping("/l3")
    @ResponseBody
    public User l3(){
        return user1;
//        return null;
    }

    @RequestMapping("l4/{id}")
    @ResponseBody
    public User l4(@PathVariable("id") Integer id){
        System.out.println(id);
        return user1;
    }

    @RequestMapping(value="l5/{id}",method={RequestMethod.GET, RequestMethod.POST})
    public String l5(@PathVariable("id") Integer id){
        System.out.println(id);
        if(Integer.compare(id,200)==0){
            throw new RuntimeException("请求路径参数id=200，出现异常");
        }
        return "redirect:/login/l2";

    }
}
