package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        TreeMap<String,Double> list = new TreeMap<>();
        String lines ="";
        BufferedReader reader = new BufferedReader(fileReader);
        while (reader.ready()){
            String line = reader.readLine();
            String [] arrayLine = line.split(" ");
            if (arrayLine.length==2){
                if (!list.containsKey(arrayLine[0])){
                    list.put(arrayLine[0],Double.parseDouble(arrayLine[1]));
                }
                else list.put(arrayLine[0],list.get(arrayLine[0])+Double.parseDouble(arrayLine[1]));
            }

        }


        fileReader.close();
        for (Map.Entry<String, Double> pair : list.entrySet()){
            System.out.println(pair.getKey()+" "+pair.getValue());
        }

    }
}
