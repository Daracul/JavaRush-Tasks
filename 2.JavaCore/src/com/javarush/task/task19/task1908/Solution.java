package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        String digits="";
        while (bufferedReader.ready()){
            String s = bufferedReader.readLine();
            String[] arrayS = s.split("\\s");
            for (String i:arrayS){
                if (i.matches("\\d+")){
                    digits+=i+" ";
                }
            }
        }
        bufferedReader.close();;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
        bufferedWriter.write(digits,0,digits.length()-1);
        bufferedWriter.close();
    }
}
