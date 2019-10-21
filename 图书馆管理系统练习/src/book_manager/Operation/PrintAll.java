package book_manager.Operation;

import book_manager.book.BookList;

public class PrintAll implements IO{
    @Override
    public void work(BookList bookList) {
        for(int i=0;i<bookList.getSize();i++){
            System.out.println(bookList.getBook(i));
        }
    }
}
