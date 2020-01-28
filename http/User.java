package http;
public class User{
    String id ;
    String name;
    String show;
    String avatarUrl;

    public User(String id, String name, String avatarUrl,String show) {
        this.id = id;
        this.name = name;
        this.show = show;
        this.avatarUrl = avatarUrl;
    }
}