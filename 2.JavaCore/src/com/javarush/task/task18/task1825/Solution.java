package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNames;
        TreeSet<String> filesInOrder = new TreeSet<>();
        while (!(fileNames=reader.readLine()).equals("end")){
            filesInOrder.add(fileNames);
        }
        reader.close();

        File newFile = new File(filesInOrder.last().substring(0,filesInOrder.last().lastIndexOf('.')));

        FileOutputStream fos = new FileOutputStream(newFile);
        for (String files:filesInOrder){
            FileInputStream fis = new FileInputStream(files);
            byte[] data = new byte[fis.available()];
            int count = fis.read(data);
            fos.write(data);
            fis.close();
        }
        fos.close();
    }
}
