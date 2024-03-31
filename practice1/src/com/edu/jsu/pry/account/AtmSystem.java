package com.edu.jsu.pry.account;

import java.util.ArrayList;
import java.util.Scanner;
public class AtmSystem {
    private static final String ADD_ACCOUNT = "1";
    private static final String QUERY_ACCOUNT = "2";
    private static final String DATA_ACCOUNT = "3";
    private static final String DEPOSIT = "4";
    private static final String WITHDRAWAL = "5";
    private static final String TRANSFER = "6";
    private static final String EXIT = "7";

    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        loop: while (true) {
            System.out.println("-----------欢迎来到ATM管理系统-----------");
            System.out.println("添加账户:\t1");
            System.out.println("查询账户:\t2");
            System.out.println("修改账户:\t3");
            System.out.println("存款:\t\t4");
            System.out.println("取款:\t\t5");
            System.out.println("转账:\t\t6");
            System.out.println("退出:\t\t7");
            System.out.println("请输入您的选择");

            String choose = sc.next();

            switch (choose){
                case ADD_ACCOUNT -> addAccount(list);
                case QUERY_ACCOUNT -> queryAccount(list);
                case DATA_ACCOUNT -> dataAccount(list);
                case DEPOSIT -> deposit(list);
                case WITHDRAWAL -> withdrawal(list);
                case TRANSFER -> transfer(list);
                case EXIT -> {
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("没有这个选项, 请重新选择");
            }
        }
    }
    // 添加账户
    public static void addAccount(ArrayList<User> list){
        System.out.println("添加账户");
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入用户的id");
            id = sc.next();
            if(contains(list, id))
                System.out.println("id已存在, 请重新输入");
            else
                break;
        }


        System.out.println("请输入用户的姓名");
        String name = sc.next();

        System.out.println("请输入用户想要存入的数额");
        int deposit = sc.nextInt();

        User user = new User(id, name, deposit);
        list.add(user);
        System.out.println("账户添加成功");
    }

    // 查询账户
    public static void queryAccount(ArrayList<User> list){
        System.out.println("查询账户");
        if(list.isEmpty()) {
            System.out.println("暂无账户信息,请添加账户后重试");
            return;
        }

        System.out.println("id\t\t\t姓名\t余额");
        for (User account : list) {
            System.out.println(account.getId() + "\t" + account.getName() + "\t" + account.getDeposit());
        }

    }
     // 修改账户
    public static void dataAccount(ArrayList<User> list){
        System.out.println("修改账户");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的账户id");

        String oldId;
        int index;
        while(true){
            oldId = sc.next();
            index = getIdIndex(list, oldId);
            if(index < 0){
                System.out.println("账户不存在, 请重新输入账户id");
            } else
                break;
        }

        System.out.println("请输入你想要修改的id");
        String newId;

        while (true) {
            newId = sc.next();
            if(contains(list, newId))
                System.out.println("该账户已存在, 请重新输入账户id");
            else
                break;
        }

        list.get(index).setId(newId);
    }
    // 存款
    public static void deposit(ArrayList<User> list){
        System.out.println("存款");
        Scanner sc = new Scanner(System.in);
        int index;
        while (true) {
            System.out.println("请输入你的账户id");
            String id = sc.next();
            index = getIdIndex(list, id);
            if(index < 0)
                System.out.println("id不存在, 请重新输入");
            else
                break;
        }

        System.out.println("请输入你要存入的数额");
        int money = sc.nextInt();

        save(list, index, money);
    }
    // 取款
    public static void withdrawal(ArrayList<User> list){
        System.out.println("取款");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的账户id");
        int index;
        String id;
        while(true){
            id = sc.next();
            index = getIdIndex(list, id);
            if(index < 0)
                System.out.println("id不存在,请重新输入");
            else
                break;
        }

        System.out.println("请输入你想要取走的数额");
        int draw = sc.nextInt();

        save(list, index, -draw);
    }
    // 转账
    public static void transfer(ArrayList<User> list){
        System.out.println("转账");

        Scanner sc = new Scanner(System.in);
        String id, objectId;
        int index, objectindex;

        while(true) {
            System.out.println("请输入你的账户id");
            id = sc.next();
            index = getIdIndex(list, id);

            if(index < 0) {
                System.out.println("该账户不存在, 请重新输入");
            }
            else
                break;
        }
        System.out.println("请输入你转账对象的账户id");

        while(true){
            objectId = sc.next();
            objectindex = getIdIndex(list, objectId);
            if(objectindex < 0)
                System.out.println("该账户不存在, 请重新输入");
            else
                break;
        }
        System.out.println("请输入你要转账的数额");

        int money = sc.nextInt();
        save(list, index, -money);
        save(list, objectindex, money);

    }

    public static boolean contains(ArrayList<User> list, String id){
        /*for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id))
        }*/

        return getIdIndex(list, id) >= 0;
    }

    public static int getIdIndex(ArrayList<User> list, String id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }

    public static void save(ArrayList<User> list, int index, int saveMoney){
        Scanner sc = new Scanner(System.in);
        while(true){
            if(saveMoney > list.get(index).getDeposit()) {
                System.out.println("余额不足, 请重新输入");
                saveMoney = sc.nextInt();
            }
            else
                break;
        }
        list.get(index).setDeposit(list.get(index).getDeposit() + saveMoney);
    }
}
