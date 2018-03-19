package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String result = "";
        TreeSet<Integer> treeSet = new TreeSet<>();
        FileReader reader = new FileReader(args[0]);
        while (reader.ready()){
            int character = reader.read();
            if (Character.isAlphabetic(character)){
                treeSet.add(Character.toLowerCase(character));
            }
        }
            for (int ch:treeSet){
                result+=(char)ch;
            }
        if (result.length()>5){
            result=result.substring(0,5);
        }

        System.out.println(result);
    }
}
