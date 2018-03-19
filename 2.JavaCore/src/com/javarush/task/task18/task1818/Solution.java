package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3=reader.readLine();
        reader.close();
        FileOutputStream fos1 = new FileOutputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);
        FileInputStream fis3 = new FileInputStream(file3);
        while (fis2.available()>0){
            fos1.write(fis2.read());
        }
        while (fis3.available()>0){
            fos1.write(fis3.read());
        }
        fos1.close();fis2.close();fis3.close();
    }
}
