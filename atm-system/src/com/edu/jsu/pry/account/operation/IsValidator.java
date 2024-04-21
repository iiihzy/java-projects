package com.edu.jsu.pry.account.operation;

import java.util.Scanner;

public class IsValidator {
    public static String isValidator () {
        Scanner sc = new Scanner(System.in);
        String idcard = null;
        String pattern = "^[0-9]{17}[0-9Xx]$";

        while (true) {
            System.out.println("请输入你的身份证");
            idcard = sc.next();
            if(idcard == null || !idcard.matches(pattern)) {
                System.out.println("身份证格式错误, 请重新输入!");
            }
            else
                break;
        }
        return idcard;
    }
}
