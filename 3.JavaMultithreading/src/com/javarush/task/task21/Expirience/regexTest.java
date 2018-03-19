package com.javarush.task.task21.Expirience;

import java.util.StringTokenizer;

/**
 * Created by amalakhov on 20.04.2017.
 */
public class regexTest {
    public static void main(String[] args) {
       String s="+38(050)12345677";
        String s2=s.replaceAll("[^0-9]","");
        System.out.println(s2);
        System.out.println(s.matches("\\+?\\d*(\\(\\d{3}\\))?\\d*(-?\\d+)?-?\\d+"));
        System.out.println(s.length());
    }
}
