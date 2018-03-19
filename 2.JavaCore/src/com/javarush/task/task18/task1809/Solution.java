package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1=reader.readLine();
        String fname2=reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(fname1);
        FileOutputStream fos = new FileOutputStream(fname2);
        byte[] buffer = new byte[fis.available()];
        int count=fis.read(buffer);
        for (int i=buffer.length-1;i>=0;i--){
            fos.write(buffer[i]);
        }
        fis.close();fos.close();
    }
}
