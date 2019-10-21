package book_manager.Operation;

import book_manager.book.Book;
import book_manager.book.BookList;

import java.util.Scanner;

public class Borrow implements IO{
    @Override
    public void work(BookList bookList) {
        int i=0;
        int flag=0;
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入需要借阅的书名");
        String name = scan.next();
        for(;i<bookList.getSize();i++){
            if(name.equals(bookList.getBook(i).getName())){
                if(bookList.getBook(i).isBorrow()==false){
                    System.out.println("借阅成功");
                    flag=1;
                    bookList.getBook(i).setBorrow(true);
                }

                }
            }
        if(flag==0){
            System.out.println("不好意思，借阅失败");
        }

    }
}
