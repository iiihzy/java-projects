package com.edu.jsu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test3 {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = getCode();
        System.out.println("当前验证码为 " + str);
        while (true) {
            System.out.println("请输入验证码");
            if(sc.next().equalsIgnoreCase(str))
                break;
            System.out.println("验证码错误, 请重新输入");
        }
    }

}
