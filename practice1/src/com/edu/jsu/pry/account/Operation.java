package com.edu.jsu.pry.account;

import com.edu.jsu.pry.inter.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Operation implements AddAccount, QueryAccount, DataAccount, Deposit, WithDrawal, Transfer, Log, Register {
 
    public void addAccount(ArrayList<User> list) {
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

    public void queryAccount(ArrayList<User> list) {
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

    public void dataAccount(ArrayList<User> list) {
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

    public void deposit(ArrayList<User> list) {
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

    public void withdrawal(ArrayList<User> list) {
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

    public void transfer(ArrayList<User> list) {
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

    public boolean contains(ArrayList<User> list, String id){
        /*for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id))
        }*/

        return getIdIndex(list, id) >= 0;
    }

    public int getIdIndex(ArrayList<User> list, String id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }

    public void save(ArrayList<User> list, int index, int saveMoney){
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


    @Override
    public void log() {

    }

    @Override
    public void register() {

    }
}

