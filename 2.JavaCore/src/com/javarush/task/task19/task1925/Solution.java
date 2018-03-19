package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String result="";
        while (reader.ready()){
            String[] line = reader.readLine().split(" ");
            for (String s:line){
                if (s.length()>6){
                    result+=s+",";
                }
            }
        }
        reader.close();
        writer.write(result.replaceAll("\\,+$",""));
        writer.close();
    }
}
