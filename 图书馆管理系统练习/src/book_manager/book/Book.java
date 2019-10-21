package book_manager.book;

public class Book {
    private String name;
    private String id;
    private String author;
    private int price;
    private String type;
    private boolean isBorrow;

    public Book(String name, String id, String author, int price,
                String type, boolean isBorrow) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.price = price;
        this.type = type;
        this.isBorrow = isBorrow;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrow=" + isBorrow +
                '}';
    }

    public String getName(){
        return name;
    }

    public boolean isBorrow(){
        return isBorrow;
    }

    public void setBorrow(boolean bool){
        this.isBorrow=bool;
    }

    public String getId(){
        return id;
    }
}
