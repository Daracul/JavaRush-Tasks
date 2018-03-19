package com.javarush.task.task22.task2212;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        boolean checking = false;
        if (telNumber==null||telNumber.isEmpty()||telNumber.equals("")){
            return checking;
        }
        else if (telNumber.matches("^\\+?\\d*([(]\\d{3}[)])?(\\d+-?\\d+-?\\d+)?\\d*$")){
                if (telNumber.charAt(0)=='+'){
                    if (telNumber.replaceAll("[^0-9]","").matches("\\d{12}")){
                        checking=true;
                    }
                }
                else if (telNumber.charAt(0)!='+'){
                    if (telNumber.replaceAll("[^0-9]","").matches("\\d{10}")){
                        checking=true;
                    }
                }
            }

        return checking;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+(012)1-2345678-9"));

    }
}
