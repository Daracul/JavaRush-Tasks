package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String s = "";
        BufferedReader bufferedReader=new BufferedReader(new FileReader(fileName));
        int count=0;
        while (bufferedReader.ready()) {
            s = bufferedReader.readLine();
            String[] array = s.replaceAll("\\pP", " ").toLowerCase().split(" ");
            for (String words:array){
                if (words.equals("world")){
                    count++;
                }
            }
        }
        reader.close();
        bufferedReader.close();
        System.out.println(count);

    }
}
