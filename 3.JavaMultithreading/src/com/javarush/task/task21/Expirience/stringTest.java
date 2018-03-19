package com.javarush.task.task21.Expirience;

/**
 * Created by amalakhov on 18.04.2017.
 */
public class stringTest {
    public static void main(String[] args) {
        String s="JavaRush - лучший сервис обучения Java.";
        char[] sToArray = s.toCharArray();
        int first = s.indexOf(" ");
        int count=0;
        int index=0;
        for (int i=0;i<sToArray.length;i++) {
            if (sToArray[i]==32){
                count++;
                if (count==5){
                    index=i;
                }
            }
        }
       System.out.println(s.substring(first,index));



    }
}
