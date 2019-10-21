package book_manager.Operation;

import book_manager.book.BookList;

import java.util.Scanner;

public class Find implements IO{
    @Override
    public void work(BookList bookList) {
        int i=0;
        int count=0;
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入需要查找的书名");
        String name = scan.next();
        for(;i<bookList.getSize();i++){
            if(name.equals(bookList.getBook(i).getName())){
                count++;
            }
        }
        if(count==0){
            System.out.println("不好意思，没有找到");
        }
        else{
            System.out.println("找到了，共计"+count+"本");
        }
    }
}
