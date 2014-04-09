package com.jeffy.thread.myself;

/**
 * Created by Administrator on 14-4-9.
 */
class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted : " + isInterrupted());
        }

        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
           System.out.println("Interrupted");
        }

        System.out.println(getName() + " join completed");
    }
}

public class Joining {
    public static void main(String[] args) {
        Sleeper s1 = new Sleeper("s1", 1500), s2 = new Sleeper("s2", 1500);
        Joiner j1 = new Joiner("j1", s1), j2 = new Joiner("j2", s2);

        s2.interrupt();
    }
}
