package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        long number = Long.valueOf(args[1]);
        String text = args[2];
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0],"rw");
        randomAccessFile.seek(number);
        byte[] bytes = new byte[text.length()];
        randomAccessFile.read(bytes,0,bytes.length);
        String readText = new String(bytes);
        String writeToFile = readText.equals(text)? "true" :"false";
        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.write(writeToFile.getBytes());

        randomAccessFile.close();

    }

}
