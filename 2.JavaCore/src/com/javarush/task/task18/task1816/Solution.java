package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int count=0;
        while (fis.available()>0){
            int r=fis.read();
            if ((r>=65&&r<=90)||(r>=97&&r<=122)){
                count++;
            }
        }
        fis.close();
        System.out.println(count);
    }
}
