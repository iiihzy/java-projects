package com.edu.jsu.pry.account.operation;

import java.util.Scanner;

public class Verify {
    public static void verify() {
        Scanner sc = new Scanner(System.in);
        String str = new Operation().getCode();
        System.out.println("当前验证码为 " + str);
        while (true) {
            System.out.println("请输入验证码");
            if(sc.next().equalsIgnoreCase(str))
                break;
            System.out.println("验证码错误, 请重新输入");
        }
    }
}
