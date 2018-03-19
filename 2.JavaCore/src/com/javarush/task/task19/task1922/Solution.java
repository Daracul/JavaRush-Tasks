package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("file");
        words.add("vid");
        words.add("V");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        while (fileReader.ready()){
            String text=fileReader.readLine();
            String[] line=text.split(" ");
            int count=0;
            for (String s:line){
            if (words.contains(s)) count++;
            }
            if (count==2){
                System.out.println(text);
            }
        }
        fileReader.close();
    }
}
