package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String,Double> map = new TreeMap<>();
        String line;
        while ((line=fileReader.readLine())!=null){
            String[] array = line.split(" ");
            if (!map.containsKey(array[0])){
                map.put(array[0],Double.parseDouble(array[1]));
            }
            else map.put(array[0],map.get(array[0])+Double.parseDouble(array[1]));
        }
        fileReader.close();
        double max=0;
        for (Map.Entry<String,Double> pair : map.entrySet()){
            if (pair.getValue()>max){
                max=pair.getValue();
            }
        }
        for (String key : map.keySet()){
            if (map.get(key)==max){
                System.out.println(key);
            }
        }
    }
}
