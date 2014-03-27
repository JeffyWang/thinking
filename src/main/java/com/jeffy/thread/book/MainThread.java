package com.jeffy.thread.book;

public class MainThread {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        LiftOff launch = new LiftOff();
        launch.run();
        Long endTime = System.currentTimeMillis();
        Long time = endTime - startTime;
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("used time : " + time);
    }
}
