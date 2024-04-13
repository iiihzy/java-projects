package com.edu.jsu.pry.account;

import com.edu.jsu.pry.inter.*;
import com.edu.jsu.pry.myexception.IdFormatException;
import com.edu.jsu.pry.myexception.NameFormatException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Operation implements AddAccount, QueryAccount, DataAccount, Deposit, WithDrawal, Transfer, Log, Register, ForgetPassword {

    public void addAccount(ArrayList<User> list) {

    }

    public void addAccount(ArrayList<User> list, User user) {
        Scanner sc = new Scanner(System.in);
        String id;
        String passWord;
        String examPassWord;

        while (true) {
            System.out.println("请输入用户的id");
            id = sc.next();
            try {
                user.setId(id);
            } catch (IdFormatException e) {
                System.out.println("非法id, 请重新输入");
                continue;
            }
            if (contains(list, id))
                System.out.println("id已存在, 请重新输入");
            else
                break;
        }

        while (true) {
            System.out.println("请输入1~6位数字密码");
            while (true) {
                try {
                    passWord = sc.next();
                    user.setPassword(passWord);
                    break;
                } catch (NameFormatException e) {
                    System.out.println("格式错误, 密码为1~6位数字密码, 请重新输入");
                }
            }

            System.out.println("请再次输入密码");
            while (true) {
                try {
                    examPassWord = sc.next();
                    user.setPassword(examPassWord);
                    break;
                } catch (NameFormatException e) {
                    System.out.println("格式错误, 密码为1~6位数字密码, 请重新输入");
                }
            }

            if (!passWord.equals(examPassWord))
                System.out.println("前后密码输入不一致, 请重新输入");
            else
                break;
        }

        System.out.println("请输入用户的姓名");
        while (true) {
            try {
                user.setName(sc.next());
                break;
            } catch (NameFormatException e) {
                System.out.println("非法名字, 请重新输入");
            }
        }

        System.out.println("请输入用户想要存入的数额");
        try {
            user.setDeposit(sc.nextInt());
        } catch (MoneySetEXception e) {

        }

        list.add(user);
        System.out.println("注册成功");
    }

    public void queryAccount(User user){
        System.out.println("id\t\t\t姓名\t余额");
        System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getDeposit());
        return;
    }
    public void queryAccount(ArrayList<User> list) {
        System.out.println("查询账户");
        if (list.isEmpty()) {
            System.out.println("暂无账户信息,请添加账户后重试");
            return;
        }

        System.out.println("id\t\t\t姓名\t余额");
        for (User account : list) {
            System.out.println(list.size());
            System.out.println(account.getId() + "\t" + account.getName() + "\t" + account.getDeposit());
        }

    }

    public void dataAccount(ArrayList<User> list) {
        System.out.println("修改账户");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的账户id");

        String oldId;
        int index;
        while (true) {
            oldId = sc.next();
            index = getIdIndex(list, oldId);
            if (index < 0) {
                System.out.println("账户不存在, 请重新输入账户id");
            } else
                break;
        }

        System.out.println("请输入你想要修改的id");
        String newId;

        while (true) {
            newId = sc.next();
            if (contains(list, newId))
                System.out.println("该账户已存在, 请重新输入账户id");
            else
                break;


        }


    }

    public void deposit(ArrayList<User> list) {
        System.out.println("存款");
        Scanner sc = new Scanner(System.in);
        int index;
        while (true) {
            System.out.println("请输入你的账户id");
            String id = sc.next();
            index = getIdIndex(list, id);
            if (index < 0)
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
        while (true) {
            id = sc.next();
            index = getIdIndex(list, id);
            if (index < 0)
                System.out.println("id不存在,请重新输入");
            else
                break;
        }

        System.out.println("请输入你想要取走的数额");
        int draw = sc.nextInt();

        save(list, index, -draw);
    }

    public void transfer(ArrayList<User> list , User user) {
        System.out.println("转账");

        Scanner sc = new Scanner(System.in);
        String objectId;
        int objectindex;

        System.out.println("请输入转账对象的账户id");
        while (true) {
            objectId = sc.next();
            objectindex = getIdIndex(list, objectId);
            if (objectindex < 0)
                System.out.println("该账户不存在, 请重新输入");
            else
                break;
        }
        System.out.println("请输入你要转账的数额");

        int money = 0;
        while (true) {
            money = sc.nextInt();
            try {
                user.setDeposit(user.getDeposit() - money);
                break;
            } catch (MoneySetEXception e) {
                System.out.println("余额不足,请重新输入");
            }
        }
        save(list, objectindex, money);

    }

    public boolean contains(ArrayList<User> list, String id) {
        /*for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id))
        }*/

        return getIdIndex(list, id) >= 0;
    }

    public int getIdIndex(ArrayList<User> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }

    public void save(ArrayList<User> list, int index, int saveMoney) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (saveMoney > list.get(index).getDeposit()) {
                System.out.println("余额不足, 请重新输入");
                saveMoney = sc.nextInt();
            } else
                break;
        }
        try {
            list.get(index).setDeposit(list.get(index).getDeposit() + saveMoney);
        } catch (MoneySetEXception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getCode() {
        //1.创建一个集合添加所有的大写和小写字母
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }

        StringBuilder sb = new StringBuilder();
        //2.要随机抽取4个字符
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            //获取随机索引
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }

        int number = r.nextInt(10);
        sb.append(number);


        char[] arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(arr.length);

        char temp = arr[randomIndex];
        arr[randomIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        return new String(arr);

    }

    private static User checkUserInfo(ArrayList<User> list, User useInfo) {
        //遍历集合，判断用户是否存在，如果存在登录成功，如果不存在登录失败
        for (User user : list) {
            if (user.getId().equals(useInfo.getId()) && user.getPassword().equals(useInfo.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User log(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户id");
            String id = sc.next();

            boolean flag = contains(list, id);
            if (!flag) {
                System.out.println("id" + id + "未注册，请先注册再登录");
                return null;
            }

            System.out.println("请输入密码");
            String password = sc.next();

            User useInfo;
            while (true) {
                String rightCode = getCode();
                System.out.println("当前正确的验证码为：" + rightCode);
                System.out.println("请输入验证码");
                String code = sc.next();
                if (code.equalsIgnoreCase(rightCode)) {
                    System.out.println("验证码正确");
                    break;
                } else {
                    System.out.println("验证码错误");
                }
            }
            useInfo = new User(id, password);
            User user = checkUserInfo(list, useInfo);
            if (user != null) {
                System.out.println("登录成功，即将进入ATM管理系统");
                return user;
            } else {
                System.out.println("登录失败，用户名或密码错误");
                if (i == 2) {
                    System.out.println("当前账号" + id + "被锁定，请联系项目组李斌：XXX-XXXXX");
                    //当前账号锁定之后，直接结束方法即可
                    return null;
                } else {
                    System.err.println("用户名或密码错误，还剩下" + (2 - i) + "次机会");
                }
            }


        }
        return null;
    }

    @Override
    public void register(ArrayList<User> list) {
        User user = new User();
        addAccount(list, user);
        list.add(user);
    }

    @Override
    public void forgetPassword(ArrayList<User> list) {

    }
}

