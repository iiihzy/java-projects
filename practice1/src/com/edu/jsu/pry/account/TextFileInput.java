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
                try {
                    User user = (User) ois.readObject();
                    list.add(user);
                } catch (EOFException e) {
                    break; // 到达文件末尾，退出循环
                }
            }
        } catch (IOException | ClassNotFoundException e) {

        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                // 异常处理
            }
        }
    }
}
