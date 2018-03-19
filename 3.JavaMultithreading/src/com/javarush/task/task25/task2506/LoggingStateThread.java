package com.javarush.task.task25.task2506;

/**
 * Created by amalakhov on 05.05.2017.
 */
public class LoggingStateThread extends Thread {
    Thread target;
    State state;


    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
        state=getState();
    }

    @Override
    public void run() {
        System.out.println(state);
        while (target.getState()!=State.TERMINATED){
            if (state!=target.getState()){
                state=target.getState();
                System.out.println(state);
            }
        }
    }
}
