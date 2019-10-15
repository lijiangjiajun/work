package package2;
import package1.*;
public class Test {
    public static void main(String[] args) {
        Animal cat = new Cat("bobi",13);
        Animal bird = new Bird("xixi",10);
        int age = cat.GetAge();
        System.out.println(age);
        Animal dog = new Dog("xiaobai",7);
//        System.out.println(cat.name);
//        System.out.println(dog.age);
//        System.out.println(dog.name);
    }
}
