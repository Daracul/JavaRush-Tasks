package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        TreeSet<Integer> list = new TreeSet<>();
        while (fis.available()>0){
            int data=fis.read();
            list.add(data);
        }
        fis.close();reader.close();
        for (int i:list){
            System.out.print(i+" ");
        }

    }
}
