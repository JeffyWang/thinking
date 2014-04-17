package com.jeffy.thread.book;

import java.io.IOException;

/**
 * Created by Administrator on 14-4-9.
 */
class UnresponsiveUI {
    private volatile double d = 1;
        public UnresponsiveUI() throws IOException {
            while (d > 0)
                d = d + (Math.PI + Math.E) / d;
            System.in.read();
        }
    }

    public class ResponsiveUI extends Thread {
        private static volatile double d = 1;

        public ResponsiveUI() {
            setDaemon(true);
        start();
    }

    public void run() {
        while (true)
            d = d + (Math.PI + Math.E) / d;
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
