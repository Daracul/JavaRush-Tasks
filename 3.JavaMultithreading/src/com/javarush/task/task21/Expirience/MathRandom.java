package com.javarush.task.task21.Expirience;

/**
 * Created by amalakhov on 23.05.2017.
 */
public class MathRandom {
    public static void main(String[] args) {
        String s= String.format("date_bot_%02d",(int)(Math.random()*10));
        System.out.println(s);
    }
}
