package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        ArrayList<String> list = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        while (fileReader.ready()){
            list.add(fileReader.readLine());
        }
        fileReader.close();
        if (args[0].equals("-u")) {
            for (int i=0;i<list.size();i++) {
                if (list.get(i).startsWith(args[1])){
                    list.set(i,setSpaces(args[1],8)+setSpaces(args[2],30)+setSpaces(args[args.length-2],8)+setSpaces(args[args.length-1],4));
                }
            }
        }
        String toDelete="";
        if (args[0].equals("-d")){
            for (String s : list){
                if (s.startsWith(args[1])){
                    toDelete=s;
                }
            }
        }
        list.remove(toDelete);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
        for (String s:list){
            fileWriter.write(s);
            fileWriter.newLine();
        }
        fileWriter.close();

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
