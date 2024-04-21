package com.edu.jsu.pry.account.operation;

import com.edu.jsu.pry.account.PasswordValidator;
import com.edu.jsu.pry.account.inter.*;
import com.edu.jsu.pry.currency.inter.*;
import com.edu.jsu.pry.myexception.IdFormatException;
import com.edu.jsu.pry.myexception.MoneySetEXception;
import com.edu.jsu.pry.myexception.NameFormatException;
import com.edu.jsu.pry.myexception.TelephoneNumberException;
import com.edu.jsu.pry.user.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Operation implements AddAccount, QueryAccount, DataAccount, Deposit, WithDrawal, Transfer, Log, Register, ForgetPassword {

    @Override
    public void addAccount(ArrayList<User> list) {
        User user = new User();
        System.out.println("添加账户");
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入用户的id");

            try {
                id = sc.next();
                user.setId(id);
                break;
            } catch (IdFormatException e) {
                System.out.println("id格式错误, 请重新输入");
            }
        }


        System.out.println("请输入用户的姓名");
        String name;
        while (true) {
            try {
                name = sc.next();
                user.setName(name);
                break;
            } catch (NameFormatException e) {
                System.out.println("姓名格式错误, 请重新输入!");
            }

    }

        System.out.println("请输入用户想要存入的数额");
        int deposit;
        while (true) {
            try {
                deposit = sc.nextInt();
                user.setDeposit(deposit);
                break;
            } catch (MoneySetEXception e) {
                System.out.println("存款数额不能为负, 请重新操作!");
            }
        }


        list.add(user);
        System.out.println("账户添加成功");
}

    @Override
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

    @Override
    public void queryAccount(User user) {
        System.out.println("id\t\t\t姓名\t余额");
        System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getDeposit());
        return;
    }

    @Override
    public void queryAccount(ArrayList<User> list) {
        System.out.println("查询账户");
        if (list.isEmpty()) {
            System.out.println("暂无账户信息,请添加账户后重试");
            return;
        }

        System.out.println("id\t\t\t姓名\t余额");
        for (User account : list) {
            System.out.println(account.getId() + "\t" + account.getName() + "\t" + account.getDeposit());
        }

    }

    @Override
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

    @Override
    public void deposit(User user) {
        System.out.println("存款");
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要存储的数额");
        int moeny = 0;
        while (true) {
            moeny = sc.nextInt();
            if (moeny < 0) {
                System.out.println("存储数额不能为负, 请重新输入");
                continue;
            }
            break;
        }
        try {
            user.setDeposit(moeny + user.getDeposit());
            System.out.println("存储成功!");
        } catch (MoneySetEXception e) {

        }
    }

    @Override
    public void deposit(ArrayList<User> list) {
        System.out.println("存款");
        Scanner sc = new Scanner(System.in);
        int index;
        while (true) {
            System.out.println("请输入你需要存款的账户id");
            String id = sc.next();
            index = getIdIndex(list, id);
            if (index < 0)
                System.out.println("id不存在, 请重新输入");
            else
                break;
        }

        System.out.println("请输入你要存入的数额");
        int money = 0;
        while (true) {
            money = sc.nextInt();
            if (money < 0) {
                System.out.println("存储数额不能为负, 请重新输入");
                continue;
            }
            break;
        }
        save(list, index, money);
    }

    @Override
    public void withdrawal(User user) {
        System.out.println("取款");
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你想要取走的数额");
        int draw = 0;
        while (true) {
            draw = sc.nextInt();
            if (draw < 0) {
                System.out.println("取款数额不能为负, 请重新输入");
                continue;
            }
            break;
        }

        while (true) {
            try {
                user.setDeposit(user.getDeposit() - draw);
                break;
            } catch (MoneySetEXception e) {
                System.out.println("余额不足, 请重新输入!");
            }
        }
    }

    @Override
    public void withdrawal(ArrayList<User> list) {
        System.out.println("取款");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要取款账户id");
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
        int draw = 0;
        while (true) {
            draw = sc.nextInt();
            if (draw < 0) {
                System.out.println("取款数额不能为负, 请重新输入");
                continue;
            }
            break;
        }

        save(list, index, -draw);
    }

    @Override
    public void transfer(ArrayList<User> list) {
        System.out.println("转账");

        Scanner sc = new Scanner(System.in);
        String id, objectId;
        int index, objectindex;

        while (true) {
            System.out.println("请输入你的账户id");
            id = sc.next();
            index = getIdIndex(list, id);

            if (index < 0) {
                System.out.println("该账户不存在, 请重新输入");
            } else
                break;
        }
        System.out.println("请输入你转账对象的账户id");

        while (true) {
            objectId = sc.next();
            objectindex = getIdIndex(list, objectId);
            if (objectindex < 0)
                System.out.println("该账户不存在, 请重新输入");
            else
                break;
        }
        System.out.println("请输入你要转账的数额");

        int money = sc.nextInt();
        save(list, index, -money);
        save(list, objectindex, money);

    }
    @Override
    public void transfer(ArrayList<User> list, User user) {
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

    public boolean contains(ArrayList<User> list, String telephoneNumber) {
        /*for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id))
        }*/

        return getTelephoneNumberIndex(list, telephoneNumber) >= 0;
    }

    public int getIdIndex(ArrayList<User> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }
    public int getTelephoneNumberIndex(ArrayList<User> list, String number) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTelephoneNumber().equals(number))
                return i;
        }
        return -1;
    }

    public void save(ArrayList<User> list, int index, int saveMoney) {
        Scanner sc = new Scanner(System.in);
        try {
            list.get(index).setDeposit(list.get(index).getDeposit() + saveMoney);
        } catch (MoneySetEXception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCode() {
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

    public static User checkUserInfo(ArrayList<User> list, User useInfo) {

        for (User user : list) {
            if (user.getTelephoneNumber().equals(useInfo.getTelephoneNumber()) && user.getPassword().equals(useInfo.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User log(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入手机号码");
            String telephoneNumber = sc.next();

            boolean flag = contains(list, telephoneNumber);
            if (!flag) {
                System.out.println("电话号码" + telephoneNumber + "未注册，请先注册再登录");
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
            useInfo = new User(telephoneNumber, password);
            User user = checkUserInfo(list, useInfo);
            if (user != null) {
                System.out.println("登录成功，即将进入ATM管理系统");
                return user;
            } else {
                System.out.println("登录失败，用户名或密码错误");
                if (i == 2) {
                    System.out.println("当前账号被锁定，请联系项目组李斌：XXX-XXXXX");
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
        Scanner sc = new Scanner(System.in);
        User user = new User();
        String number;

        String idCard = IsValidator.isValidator();
        user.setIdCard(idCard);
        while (true) {
            System.out.println("请输入用户的电话号码!");
            number = sc.next();

            try {
                user.setTelephoneNumber(number);
            } catch (TelephoneNumberException e) {
                System.out.println("非法电话号码, 请重新输入!");
                continue;
            }

            if (getTelephoneNumberIndex(list, number) >= 0)
                System.out.println("电话号码已存在, 请重新输入");
            else
                break;
        }

        while (true) {
            System.out.println("请输入你的密码, 密码长度6~18, 且至少包含英文字母和数字");
            String passWord = sc.next();
            while(!PasswordValidator.isValidPassword(passWord)) {
                System.out.println("密码格式错误, 密码长度6~18, 且至少包含英文字母和数字!");
            }
            System.out.println("请再次输入你的登录密码");
            String oldPassWord = sc.next();
            while(!PasswordValidator.isValidPassword(oldPassWord)) {
                System.out.println("密码格式错误, 密码长度6~18, 且至少包含英文字母和数字!");
            }
            if(!passWord.equals(oldPassWord)) {
                System.out.println("前后密码不一致, 请重新输入");
                continue;
            }
            try {
                user.setPassword(passWord);
            } catch (NameFormatException e) {
                e.printStackTrace();
            }
            break;
        }

        Verify.verify();
        list.add(user);
    }

    @Override
    public void forgetPassword(ArrayList<User> list) {

    }
}

