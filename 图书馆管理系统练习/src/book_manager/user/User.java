package book_manager.user;

import book_manager.Operation.*;
import book_manager.Operation.IO;
import book_manager.book.BookList;

abstract public class User {
    String name;
    protected IO[] operation;



    public User(String name){
        this.name=name;
    }

    abstract public int menu();//该方法被重写
    public void doOperation(int choice, BookList bookList) {
        operation[choice].work(bookList);
    }
}
