package com.jeffy.thread.myself;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 14-4-1.
 */
public class DaemonThread implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        int sleepTime = (random.nextInt(10) + 1) * 1000;
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The thread sleep " + sleepTime + "ms");
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 6; i ++) {
            Thread thread = new Thread(new DaemonThread());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(50000);
    }
}
