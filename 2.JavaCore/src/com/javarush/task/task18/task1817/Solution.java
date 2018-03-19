package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int count=0;
        int length = fis.available();
        while (fis.available()>0){
            int r=fis.read();
            if (r==32){
                count++;
            }
        }
        fis.close();
        System.out.println(String.format("%.2f",count/(double)length*100));

    }
}
