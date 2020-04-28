package frank.controller;

import frank.model.User;
import frank.servive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user2")
public class User2Controller {
    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    @ResponseBody
    public User insert(User user){
        int num = userService.insert(user);
        return user;
    }

    @RequestMapping("/query")
    @ResponseBody
    public User queryById(Long id){
        return userService.queryById(id);
    }
}
