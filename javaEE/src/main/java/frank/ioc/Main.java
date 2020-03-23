package frank.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");
// 新增这里
        Object o = context.getBean("myName");
        System.out.println(o.getClass());
        System.out.println(o);

//        Object animal = context.getBean("animal");
        Animal animal = (Animal) context.getBean("animal3");
        System.out.println(animal);

//        Animal animal4 = (Animal) context.getBean("animal4");
//        System.out.println(animal4);
    }
}
