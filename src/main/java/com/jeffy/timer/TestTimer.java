package com.jeffy.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 14-3-31.
 */
public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new MyTimerTask();
        timer.schedule(timerTask,500,1500);
    }
}