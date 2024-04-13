package com.edu.jsu.pry.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    /* jdk 8 以后
    private static final String ADD_ACCOUNT = "1";
    private static final String QUERY_ACCOUNT = "2";
    private static final String DATA_ACCOUNT = "3";
    private static final String DEPOSIT = "4";
    private static final String WITHDRAWAL = "5";
    private static final String TRANSFER = "6";
    private static final String EXIT = "7";*/

    public void displayMenu(){
            System.out.println("添加账户:\t1");
            System.out.println("查询账户:\t2");
            System.out.println("修改账户:\t3");
            System.out.println("存款:\t\t4");
            System.out.println("取款:\t\t5");
            System.out.println("转账:\t\t6");
            System.out.println("退出:\t\t7");
            System.out.println("请输入您的选择");

    }
    public User logAndRegister(ArrayList<User> list) throws IOException {
        System.out.println("-----------欢迎来到ATM管理系统-----------");

        Operation operation = new Operation();
        Scanner sc = new Scanner(System.in);
        String choose;

        loop: while (true) {
            System.out.println("请选择操作：1登录 2注册 3忘记密码 4退出");
            choose = sc.next();
            switch (choose) {
                case "1" -> {
                    User user = operation.log(list);
                    if(user != null)
                        break loop;

                }
                case "2" -> operation.register(list);
                case "3" -> operation.forgetPassword(list);
                case "4" -> {
                    new TextFileIOutput().textFileIOutput(list);
                    System.out.println("谢谢使用，再见");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项, 请重新选择");
            }
        }
        return null;
    }

    public void choose(ArrayList<User> list) throws IOException {
        User user = logAndRegister(list);
        Scanner sc = new Scanner(System.in);

        loop: while (true) {
            displayMenu();
            String choose = sc.next();
            Operation operation = new Operation();

            switch (choose){
                case "1" -> operation.addAccount(list);
                case "2" -> operation.queryAccount(list);
                case "3" -> operation.dataAccount(list);
                case "4" -> operation.deposit(list);
                case "5" -> operation.withdrawal(list);
                case "6" -> operation.transfer(list);
                case "7" -> {
                    try {
                        new TextFileIOutput().textFileIOutput(list);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("没有这个选项, 请重新选择");
            }
        }
    }

}
