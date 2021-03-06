package com.javarush.task.task21.Expirience;

/**
 * Created by amalakhov on 05.05.2017.
 */
public class JavaUncaughtExceptionHandlerExample {

    public static void main(String[] args) {

        Thread myThread = new Thread(new TestThread());

        myThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            public void uncaughtException(Thread myThread, Throwable e) {
                System.out.println(myThread.getName() + " throws exception: " + e);
            }
        });
        // this will call run() function
        myThread.start();
    }
}

 class TestThread implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException();
    }
}

