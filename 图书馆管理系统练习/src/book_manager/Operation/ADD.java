package book_manager.Operation;

import book_manager.book.*;

import java.util.Scanner;

public class ADD implements IO{

    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名");
        String name =scanner.next();
        System.out.println("请输入序号");
        String id = scanner.next();
        System.out.println("请输入作者");
        String author =scanner.next();
        System.out.println("请输入价格");
        int price = scanner.nextInt();
        System.out.println("请输入类型");
        String type = scanner.next();
        Book book = new Book(name, id,
                author, price, type, false);
        bookList.setBooks(bookList.getSize(),book);
        bookList.setSize(bookList.getSize()+1);
        System.out.println("添加成功");
    }
}
