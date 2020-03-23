package frank.ioc;

public class AnimalFactory2 {
    public  Animal newInstance(){
        Animal animal = new Animal("实例工厂方法创建的动物",4);
        return animal;
    }
}

