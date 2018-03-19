package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader filereader = new BufferedReader(new FileReader(file));
        while (true){
            String s =filereader.readLine();
            if (s.startsWith(args[0])){
                System.out.println(s);
                break;
            }
        }
        filereader.close();
    }
}
