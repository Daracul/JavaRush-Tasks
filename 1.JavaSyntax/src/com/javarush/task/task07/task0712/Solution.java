package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> tmplist = new ArrayList<Integer>();
        for (int i =0;i<10;i++){
            list.add(reader.readLine());
        }
        int min=list.get(0).length();
        int max =list.get(0).length();
        int counMin=0;
        int counMx=0;
        for (int i=0;i<list.size();i++){
            if (list.get(i).length()<min){
                min=list.get(i).length();
                counMin=i;
            }
        }
        for (int i=0;i<list.size();i++){
            if (list.get(i).length()>max){
                max=list.get(i).length();
                counMx=i;
            }
        }
        if (counMin<counMx){
            System.out.println(list.get(counMin));
        }
        else System.out.println(list.get(counMx));
    }
}

