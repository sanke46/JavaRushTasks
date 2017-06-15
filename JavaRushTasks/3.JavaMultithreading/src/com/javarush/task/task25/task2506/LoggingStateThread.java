package com.javarush.task.task25.task2506;

/**
 * Created by ilafedoseev on 15.06.17.
 */
public class LoggingStateThread extends Thread{
    private Thread logTarget;

    public LoggingStateThread(Thread thread) {
        logTarget = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        State lastState;
        lastState = logTarget.getState();
        System.out.println(lastState);

        while (lastState != State.TERMINATED){
            if(lastState != logTarget.getState()){
                System.out.println(logTarget.getState());
                lastState = logTarget.getState();
            }
        }
    }
}
