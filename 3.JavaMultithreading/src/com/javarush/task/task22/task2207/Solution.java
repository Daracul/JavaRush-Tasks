package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        ArrayList<String> listOfStrings = new ArrayList<>();
        String s="";
        while (fileReader.ready()){
            s+=fileReader.readLine()+" ";
        }
        fileReader.close();
        String[] list = s.split(" ");
        for (int i=0;i<list.length;i++){
            String reverse = new StringBuilder(list[i]).reverse().toString();
            for (int j=0;j<list.length;j++){
                if ((reverse.equals(list[j]))&&(!listOfStrings.contains(list[i]))&&(!listOfStrings.contains(reverse))){
                    listOfStrings.add(list[i]);
                }
            }
        }
        for (String se:listOfStrings){
            String reverse = new StringBuilder(se).reverse().toString();
            System.out.println(se+" "+reverse);
            Pair pair = new Pair();
            pair.first=reverse;
            pair.second=se;
            result.add(pair);
        }
        System.out.println(result);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }

    }

}
