package frank.config;

import frank.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class MyConfig {

    @Bean("user1")
    public User user1(){
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setNickname("隔壁老王");
        user.setEmail("xxx@qq.com");
        user.setBirthday(new Date());
        return user;
    }

    @Bean
    public User user2(){
        User user = new User();
        user.setId(2);
        user.setUsername("王五");
        user.setNickname("隔壁老王");
        user.setEmail("xxx@qq.com");
        user.setBirthday(new Date());
        return user;
    }


}
