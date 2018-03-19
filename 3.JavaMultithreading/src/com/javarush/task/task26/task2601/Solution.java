package com.javarush.task.task26.task2601;

import java.lang.reflect.Array;
import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {


    }


    public static Integer[] sort(Integer[] array) {
        if (array.length!=0||array!=null) {
            Arrays.sort(array);
            int mediana;
            if (array.length % 2 != 0) {
                mediana = array[array.length / 2];
            } else {
                mediana = (array[(array.length / 2)] + array[(array.length / 2) - 1]) / 2;
            }

           Comparator<Integer> compareByMeridian = new Comparator<Integer>() {
               @Override
               public int compare(Integer o1, Integer o2) {

                   return Math.abs(o1-mediana)-Math.abs(o2-mediana);
               }
           };

            Arrays.sort(array,compareByMeridian);


            //implement logic here
            return array;
        }
        return null;
    }
}
