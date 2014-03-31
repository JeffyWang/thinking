package com.jeffy.thread.myself;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 14-3-31.
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i ++) {
            exec.execute(new SayNumber("jeffy" + i));
        }
        exec.shutdown();
    }
}
