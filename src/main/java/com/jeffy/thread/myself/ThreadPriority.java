package com.jeffy.thread.myself;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 14-4-1.
 */
public class ThreadPriority implements Runnable {
    private int priority;

    public ThreadPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        System.out.println("my prioriry is " + priority);
        Thread.currentThread().setPriority(priority);
        System.out.println(this);
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i =0; i < 5; i ++) {
            exec.execute(new ThreadPriority(Thread.MIN_PRIORITY));
        }
        exec.execute(new ThreadPriority(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
