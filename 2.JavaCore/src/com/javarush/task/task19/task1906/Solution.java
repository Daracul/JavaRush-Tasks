package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filName1  =reader.readLine();
        String filName2 = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(filName1);
        FileWriter fileWriter = new FileWriter(filName2);
        int count =1;
        while (fileReader.ready()){
            int data =fileReader.read();
            if (count%2==0){
                fileWriter.write(data);
            }
            count++;
        }
        fileReader.close();fileWriter.close();

    }
}
