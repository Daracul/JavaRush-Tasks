package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<10;i++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        int count=1;
        int max=0;
        for(int i=1;i<list.size();i++){
                if (list.get(i).equals(list.get(i-1))){
                    count++;
                    if (count>=max){
                        max=count;}
                }
            else count=1;
        }
        if (max==0){
            max=1;
        }

        System.out.println(max);
        //напишите тут ваш код
    }
}