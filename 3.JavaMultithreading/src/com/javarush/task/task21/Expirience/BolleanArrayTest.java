package com.javarush.task.task21.Expirience;

/**
 * Created by amalakhov on 19.05.2017.
 */
public class BolleanArrayTest {
    private static final boolean[] PARKING_PLACES = new boolean[5];
    public static void main(String[] args) {
        for (boolean b:PARKING_PLACES){
            if (!b){
                System.out.println(b);
            }
//            System.out.println(b);
        }

    }
}

