package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()){
            String line = reader.readLine();
            String[] splitted = line.split(" ");
            String name = "";
            String year = splitted[splitted.length-1];
            String month = splitted[splitted.length-2];
            String day = splitted[splitted.length-3];
            for (int i=0;i<splitted.length-3;i++){
                name+=splitted[i]+" ";
            }
            Calendar date = new GregorianCalendar(Integer.parseInt(year),Integer.parseInt(month)-1,Integer.parseInt(day));
            PEOPLE.add(new Person(name.replaceAll("\\s+$",""),date.getTime()));
        }
        reader.close();
        for (Person pers:PEOPLE){
            System.out.println(pers.getName()+" "+pers.getBirthday());
        }

    }
}
