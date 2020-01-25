import java.io.*;

public class Serialize {
    public static class Person implements Serializable{

        private String name;
        private int age;

        public Person(String name, int age) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Serialize{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputStream outputStream = new FileOutputStream("D:\\输入输出流测试文件\\有一个目录\\hello.java");
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        Person person1= new Person("李江佳俊",22);
        Person person2 = new Person("啦啦啦",21);
        oos.writeObject(person1);
        oos.writeObject(person2);


        InputStream inputStream =new FileInputStream("D:\\输入输出流测试文件\\有一个目录\\hello.java");
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        Person p1 = (Person)ois.readObject();
        Person p2 = (Person)ois.readObject();
        System.out.println(p1);
        System.out.println(p2);
    }
}
