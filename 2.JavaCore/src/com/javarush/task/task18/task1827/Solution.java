package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> fileList = new ArrayList<>();
        while (fileReader.ready()){
            fileList.add(fileReader.readLine());
        }
        fileReader.close();
        int index=0;
        for (String s:fileList){
            int tmp=Integer.parseInt(s.replaceAll("\\D{1,8}\\d{0,}",""));
            if (tmp>index){
                index=tmp;
            }

        }
        if (args[0].equals("-c")){
            String textAll=args[1];
            String id = String.valueOf(++index);

            FileWriter fw = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(fw);
            fileList.add(setSpaces(String.valueOf(++index),8)+setSpaces(textAll,30)+setSpaces((args[args.length-2]),8)+setSpaces((args[args.length-1]),4));
            for (int i=0;i<fileList.size();i++){
                if (i==fileList.size()-1){
                    writer.write(fileList.get(i));
                }
                else {
                writer.write(fileList.get(i));
                writer.newLine();}
            }
            writer.close();
        }

    }
    public static String setSpaces (String name,int numberOfSpaces){
        String newName="";
        if (name.length()>numberOfSpaces){
            newName=name.substring(0,numberOfSpaces);
        }
        else {
            while (!(name.length()==numberOfSpaces)){
                name=name+" ";
            }
            newName=name;
        }
        return newName;
    }
}
