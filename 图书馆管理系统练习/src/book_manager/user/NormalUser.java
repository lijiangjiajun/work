package book_manager.user;

import book_manager.Operation.*;

import java.util.Scanner;

public class NormalUser extends User{
    public NormalUser(String name){
        super(name);
        operation=new IO[]{
                new Exit(),
                new Find(),
                new Borrow(),
                new Return()
        };
    }
    public int menu() {
        System.out.println("============");
        System.out.println("hello " + name);
        System.out.println("1. 查找图书");
        System.out.println("2. 借阅图书");
        System.out.println("3. 归还图书");
        System.out.println("0. 退出");
        System.out.println("============");
        System.out.println("请输入您的选择: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        // close 本质上是在关闭 System.in
        // 由于后面还需要用到 System.in, 此处不能盲目关闭.
        // scanner.close();
        return choice;
    }

}
