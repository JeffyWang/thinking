package com.jeffy.thread.myself;

public class SayNumber implements Runnable {
    private String name;

    public SayNumber(String name) {
        this.name = name;
        System.out.println(this.name + " beggin to say number.");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i ++) {
            System.out.println(this.name + " say the number is " + i);
            Thread.yield();
        }
        System.out.println(this.name + " say stop say number.");
    }
}
