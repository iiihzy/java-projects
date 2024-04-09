package com.edu;

import javax.xml.crypto.Data;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.text.SimpleDateFormat;

public class Test2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");

        long start = System.currentTimeMillis();

        byte[] bytes = new byte[6];
        int len;
        while((len = fis.read(bytes)) != -1){
            fos.write(bytes, 0, len);
        }

        fos.close();
        fis.close();

        long end = System.currentTimeMillis();

        long duration = end - start;

        long milliseconds = duration % 1000;
        long seconds = duration / 1000 % 60;
        long min = duration / (1000 * 60) % 60;
        long hour = duration / (1000 * 60 * 60) % 60;

        System.out.printf("%02d时%02d分%02d秒%03d毫秒", hour, min, seconds, milliseconds);
    }
}
