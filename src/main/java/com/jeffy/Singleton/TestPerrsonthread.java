package com.jeffy.Singleton;

public class TestPerrsonthread {
    public static void main(String[] args) {
        for(int i = 0; i < 50; i ++) {
            new Thread(new PersonThread("jeffy" + i)).start();
        }
    }
}