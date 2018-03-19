package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readFromConsole.readLine();
        readFromConsole.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String words="";
        while (reader.ready()){
            words+=reader.readLine()+" ";
        }
        reader.close();
        //...
        StringBuilder result = getLine(words.split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();
        if (words.length>0) {
            ArrayList<String> list = new ArrayList<>();
            for (String s : words) {
                list.add(s);
            }
            Collections.sort(list);
            char search;
            stringBuilder.append(list.get(0));
            search = list.get(0).toLowerCase().charAt(list.get(0).length() - 1);
            list.remove(0);
            for (int i = 0; i < list.size(); ) {
                if (list.get(i).toLowerCase().charAt(0) == search) {
                    stringBuilder.append(" ").append(list.get(i));
                    search = list.get(i).toLowerCase().charAt(list.get(i).length() - 1);
                    list.remove(i);
                    i = 0;
                } else i++;
            }
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    stringBuilder.append(" ").append(list.get(i));
                }
            }
        }
        return stringBuilder;
    }
}
