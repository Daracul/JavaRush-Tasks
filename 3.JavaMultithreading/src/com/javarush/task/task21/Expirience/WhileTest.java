package com.javarush.task.task21.Expirience;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amalakhov on 23.05.2017.
 */
public class WhileTest {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean b = true;
        while (!b) {

        }
        try {
            Thread.sleep(3000);
            b=false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
