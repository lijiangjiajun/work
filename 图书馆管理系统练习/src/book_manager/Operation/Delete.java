package book_manager.Operation;

import book_manager.book.BookList;

import java.util.Scanner;

public class Delete implements IO{

    public void work(BookList bookList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入想要删除的编号");
        String id  = scanner.next();
        for(int i=0;i<bookList.getSize();i++){
            if(bookList.getBook(i).getId().equals(id)){
                bookList.setBooks(i,bookList.getBook(bookList.getSize()));
                bookList.setSize(bookList.getSize()-1);
                System.out.println("删除成功");
            }
            else{
                System.out.println("删除失败");
            }
        }
    }
}
