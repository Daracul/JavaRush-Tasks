package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        Pattern p = Pattern.compile(".*\\d+.*");
        while (reader.ready()){
            String[] line = reader.readLine().split(" ");
            for (String s:line){
                Matcher m = p.matcher(s);
                if (m.matches()){
                    writer.write(s+" ");
                }
            }
        }
        reader.close();writer.close();
    }
}
