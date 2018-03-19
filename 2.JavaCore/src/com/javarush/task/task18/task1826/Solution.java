package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        if (args[0].equals("-e")){
            fis=new FileInputStream(args[1]);
            fos = new FileOutputStream(args[2]);
            while (fis.available()>0){
                int data=fis.read();
                fos.write(data*2);
            }
        }
        if (args[0].equals("-d")){
            fis=new FileInputStream(args[1]);
            fos = new FileOutputStream(args[2]);
            while (fis.available()>0){
                int data=fis.read();
                fos.write(data/2);
            }
        }
        fis.close();
        fos.close();
    }

}
