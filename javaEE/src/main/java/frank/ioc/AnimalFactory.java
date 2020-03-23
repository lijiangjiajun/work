package frank.ioc;

public class AnimalFactory {
    public static Animal newInstance(){
        Animal animal = new Animal("工厂方法创建的动物",4);
        return animal;
    }
}



