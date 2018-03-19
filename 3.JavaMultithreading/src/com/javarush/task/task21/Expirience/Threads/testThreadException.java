package com.javarush.task.task21.Expirience.Threads;

/**
 * Created by amalakhov on 10.05.2017.
 */
public class testThreadException {
    public static void main(String[] args) {
        Thread thread = new exceptionThread();
        thread.start();
    }
}
