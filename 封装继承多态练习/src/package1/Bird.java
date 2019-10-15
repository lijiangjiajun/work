package package1;

public class Bird extends Animal {
    public Bird(String name,int age){
        super(name,age);
    }
    public void fly(){
        System.out.println(name+"正在飞");
    }
}
