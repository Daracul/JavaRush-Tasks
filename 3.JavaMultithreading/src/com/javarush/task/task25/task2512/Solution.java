package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<String > list = getExceptionMessageChain(e);
        for (int i=list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }



    }
    public static List<String> getExceptionMessageChain(Throwable throwable) {
        List<String> result = new ArrayList<String>();
        while (throwable != null) {
            result.add(throwable.toString());
            throwable = throwable.getCause();

        }
        return result; //["THIRD EXCEPTION", "SECOND EXCEPTION", "FIRST EXCEPTION"]
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run()  {
                    throw new Error("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));

            }
        };
        Thread thread = new Thread(runnable);
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }
}
