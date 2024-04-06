package com.edu.jsu.pry.account;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static final String ADD_ACCOUNT = "1";
    private static final String QUERY_ACCOUNT = "2";
    private static final String DATA_ACCOUNT = "3";
    private static final String DEPOSIT = "4";
    private static final String WITHDRAWAL = "5";
    private static final String TRANSFER = "6";
    private static final String EXIT = "7";

    public void displayMenu(){
            System.out.println("-----------欢迎来到ATM管理系统-----------");
            System.out.println("添加账户:\t1");
            System.out.println("查询账户:\t2");
            System.out.println("修改账户:\t3");
            System.out.println("存款:\t\t4");
            System.out.println("取款:\t\t5");
            System.out.println("转账:\t\t6");
            System.out.println("退出:\t\t7");
            System.out.println("请输入您的选择");

    }
    public void logAndRegisterMenuDisplay(ArrayList<User> list) {

    }

    public void choose(ArrayList<User> list){
        Scanner sc = new Scanner(System.in);

        loop: while (true) {
            displayMenu();
            String choose = sc.next();
            Operation operation = new Operation();

            switch (choose){
                case ADD_ACCOUNT -> operation.addAccount(list);
                case QUERY_ACCOUNT -> operation.queryAccount(list);
                case DATA_ACCOUNT -> operation.dataAccount(list);
                case DEPOSIT -> operation.deposit(list);
                case WITHDRAWAL -> operation.withdrawal(list);
                case TRANSFER -> operation.transfer(list);
                case EXIT -> {
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("没有这个选项, 请重新选择");
            }
        }
    }

}
