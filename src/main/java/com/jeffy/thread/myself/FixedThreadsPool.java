package com.jeffy.thread.myself;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 14-3-31.
 */
public class FixedThreadsPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i ++) {
            exec.execute(new SayNumber("jeffy" + i));
        }
        exec.shutdown();
    }
}
