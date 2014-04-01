package com.jeffy.thread.myself;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 14-4-1.
 */
public class SleepTimeThread implements Runnable {
    private int threadNum;

    public SleepTimeThread(int num) {
        this.threadNum = num;
    }
    @Override
    public void run() {
        Random random = new Random();
        int sleepTime = (random.nextInt(10) + 1) * 1000;
//        System.out.println(random.nextInt(10));
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I slept " + sleepTime + "ms");
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i ++) {
            exec.execute(new SleepTimeThread(i));
        }
        exec.shutdown();
    }
}
