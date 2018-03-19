package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while (fis.available()>0){
            int data = fis.read();
            if (!map.containsKey(data)){
                map.put(data,1);
            }
            else {
                map.put(data,map.get(data)+1);
            }
        }
        fis.close();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println((char)(int)entry.getKey()+" "+entry.getValue());
        }
    }
}
