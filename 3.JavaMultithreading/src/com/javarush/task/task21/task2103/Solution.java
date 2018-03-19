package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
//        1=1=1!=0 or 0=1 or 0=1 or 1=1
        return c&&(!b||b);
    }

    public static void main(String[] args) {
        System.out.println(calculate(true,true,true,true));
        System.out.println(calculate(true,false,false,false));
        System.out.println(calculate(true,true,false,false));
        System.out.println(calculate(true,false,false,false));
        System.out.println(calculate(false,false,false,false));
        System.out.println(calculate(false,true,false,false));
        System.out.println(calculate(false,true,true,false));
        System.out.println(calculate(false,true,true,true));

    }
}
