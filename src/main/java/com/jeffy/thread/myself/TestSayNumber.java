package com.jeffy.thread.myself;

public class TestSayNumber {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i ++) {
            new Thread(new SayNumber("jeffy" + i)).start();
        }
    }
}