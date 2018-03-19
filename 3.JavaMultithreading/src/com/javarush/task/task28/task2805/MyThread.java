package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by amalakhov on 02.06.2017.
 */
public class MyThread extends Thread {
    static AtomicInteger i = new AtomicInteger(1);
    public MyThread() {
      setPriority(countPriority());
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority(countPriority());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority(countPriority());
    }

    public MyThread(String name) {
        super(name);
        setPriority(countPriority());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority(countPriority());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority(countPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority(countPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority(countPriority());
    }

    public int countPriority(){
        int k;
        if (i.get()<10){
            k=i.getAndIncrement();
        } else {
            k=i.get();
            i.set(1);

        }
        return k;

    }
}

