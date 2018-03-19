package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            BufferedReader file1reader = new BufferedReader(new FileReader(file1));
            BufferedReader file2reader = new BufferedReader(new FileReader(file2));
            String f1=null;
            String f2=null;
            while ((f1=file1reader.readLine())!=null){
                allLines.add(f1);
            }
            while ((f2=file2reader.readLine())!=null){
                forRemoveLines.add(f2);
            }
            reader.close();
            file1reader.close();
            file2reader.close();
        }
        catch (IOException e){}
        try {
            solution.joinData();
        }
        catch (CorruptedDataException e){
            System.out.println(e);
        }
        for (String a : allLines){
            System.out.println(a);
        }
        System.out.println("-------------------");
        for (String a : forRemoveLines){
            System.out.println(a);
        }
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
