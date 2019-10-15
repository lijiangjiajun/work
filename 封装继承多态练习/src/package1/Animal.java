package package1;

public class Animal {
    protected String name;
    protected int age;
    public Animal(String name,int age){
        this.name=name;
        this.age=age;
    }

    public int GetAge(){
        return age;
    }


    public void eat(String name,String food ){
        System.out.println(name+"吃"+food );
    }
    public void Age(int age){
        System.out.println(name+"今年"+age+"岁");
    }

}
