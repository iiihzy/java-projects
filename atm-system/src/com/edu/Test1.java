package com.edu;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt", true);
        fos.write("斌哥快写作业\r\n".getBytes());
        fos.write("不要摸鱼了\r\n".getBytes());
        fos.close();

    }


}
