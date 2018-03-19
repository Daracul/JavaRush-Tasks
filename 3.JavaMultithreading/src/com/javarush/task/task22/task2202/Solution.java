package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string==null||string.isEmpty()){
            throw new TooShortStringException();
        }
        String[] stringArray = string.split(" ");
        String stringToReturn="";
        if (stringArray.length<5){
            throw new TooShortStringException();
        }


        for (int i=1;i<5;i++){
            stringToReturn+=stringArray[i]+" ";
        }


        return stringToReturn.substring(0,stringToReturn.length()-1);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
