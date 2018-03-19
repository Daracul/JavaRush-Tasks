package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fnmae1=reader.readLine();
        String fnmae2=reader.readLine();
        String fnmae3=reader.readLine();
        reader.close();
        FileInputStream fis1 = new FileInputStream(fnmae1);
        FileOutputStream fos2 = new FileOutputStream(fnmae2);
        FileOutputStream fos3 = new FileOutputStream(fnmae3);
            byte [] buffer = new byte[fis1.available()];
            int count =fis1.read(buffer);
            fos2.write(buffer,0,count/2+buffer.length%2);
            fos3.write(buffer,count/2+buffer.length%2,(count/2));
        fis1.close();fos2.close();fos3.close();
    }
}
