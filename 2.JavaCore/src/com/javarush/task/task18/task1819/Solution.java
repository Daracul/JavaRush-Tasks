package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        reader.close();
        FileInputStream fis1 = new FileInputStream(file1);
        byte[] bytes1 = new byte[fis1.available()];
        int count = fis1.read(bytes1);
        FileInputStream fis2 = new FileInputStream(file2);
        byte[] bytes2 = new byte[fis2.available()];
        fis1.close();
        int count2 = fis2.read(bytes2);
        fis2.close();
        FileOutputStream fos1 = new FileOutputStream(file1);
        fos1.write(bytes2);
        fos1.write(bytes1);
//        fos1.close();
//        FileOutputStream fos2 = new FileOutputStream(file1,true);
//        fos2.write(bytes1);

//        FileInputStream fis1 = new FileInputStream(file1);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        FileInputStream fis2 = new FileInputStream(file2);
//        byte[] bytes = new byte[fis2.available()];
//        int count = fis2.read(bytes);
//        fis2.close();
//        byteArrayOutputStream.write(bytes);
//        while (fis1.available()>0){
//            byteArrayOutputStream.write(fis1.read());
//        }
//        fis1.close();
//        FileOutputStream fos1 = new FileOutputStream(file1);
//        byteArrayOutputStream.writeTo(fos1);
//        fos1.close();byteArrayOutputStream.close();

    }
}
