package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream fis1 = new FileInputStream(file1);
        FileOutputStream fos2 = new FileOutputStream(file2);
        StringBuilder str = new StringBuilder("");
        while (fis1.available()>0){
            int r = fis1.read();
                str.append((char)r);
        }
        String digits = str.toString();
        String[] lists = digits.split(" ");
        String result="";
        for (String s:lists){
            double a = (Double.valueOf(s));
            result+=Math.round(a)+" ";
        }
        fos2.write(result.replaceAll("\\s+$", "").getBytes());
        fis1.close();fos2.close();


    }
}
