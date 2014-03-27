package com.jeffy.thread.book;

public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("start ~~~");
    }
}
