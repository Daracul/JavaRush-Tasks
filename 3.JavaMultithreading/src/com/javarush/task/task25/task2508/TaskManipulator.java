package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable,CustomThreadManipulator {
   private Thread current=new Thread();


    @Override
    public void start(String threadName) {
        current=new Thread(new TaskManipulator());
        current.setName(threadName);
        current.start();
    }

    @Override
    public void stop() {
        current.interrupt();

    }

    @Override
    public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
//                    Thread.sleep(0);
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

    }
}
