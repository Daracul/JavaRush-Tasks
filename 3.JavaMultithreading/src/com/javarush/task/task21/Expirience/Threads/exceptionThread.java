package com.javarush.task.task21.Expirience.Threads;

/**
 * Created by amalakhov on 10.05.2017.
 */
public class exceptionThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(2/0);
        }
    }
}
