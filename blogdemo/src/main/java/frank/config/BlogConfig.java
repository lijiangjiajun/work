package frank.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class BlogConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/login/l3")
                .excludePathPatterns("/")//排除根路径
                .excludePathPatterns("/index")//排除首页
                .excludePathPatterns("/login")//排除登录页面
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/a/*")  //*匹配一级路径
                // 排序static文件夹下所有的静态资源
                .excludePathPatterns("/css/**")  //**匹配多级路径
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/plugins/editor/**");
    }
}
