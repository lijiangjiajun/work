package frank.ioc;

import java.util.List;

public class Animal {
    private String name;
    private int num;
    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", tags=" + tags +
                '}';
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Animal(String name, int num) {
        this.name=name;
        this.num=num;
    }

    public Animal(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
