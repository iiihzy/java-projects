package com.edu.jsu.pry.account;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TextFileInput {

    public void textFileReader(ArrayList<User> list) {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("b.txt"));

            while (true) {
                // 尝试读取对象
                User user = (User) ois.readObject();
                // 如果成功读取到对象，则添加到列表中并打印列表大小
                if (user != null) {
                    list.add(user);
                    System.out.println(list.size());
                } else {
                    break; // 到达文件末尾，退出循环
                }
            }
        } catch (EOFException e) {
            // 到达文件末尾，不需要处理异常
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // 打印异常堆栈信息
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace(); // 打印异常堆栈信息
            }
        }
    }
}
