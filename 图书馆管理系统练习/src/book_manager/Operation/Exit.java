package book_manager.Operation;

import book_manager.book.BookList;

public class Exit implements IO{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出成功");
        System.exit(0);
    }
}
