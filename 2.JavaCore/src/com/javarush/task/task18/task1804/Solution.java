package com.javarush.task.task18.task1804;

import java.io.*;
import java.util.*;
/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (fis.available() > 0) {
            int data = fis.read();
            list.add(data);
        }
        fis.close();
        reader.close();
        for (int i = 0; i < list.size(); i++) {
            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), 1);
            } else {
                map.put(list.get(i), map.get(list.get(i)) + 1);
            }
        }
        int min = 500;
        for (int value : map.values()) {
            if (value < min) {
                min = value;
            }
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
