package com.javarush.task.task19.task1926;

/* 
Перевертыши
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
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        StringBuilder line = new StringBuilder();
        while (fileReader.ready()){
            line.append(fileReader.readLine());
            System.out.println(line.reverse());
            line.setLength(0);
        }
        fileReader.close();
    }
}
