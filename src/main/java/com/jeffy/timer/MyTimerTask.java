package com.jeffy.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Administrator on 14-3-31.
 */
public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        Date executeTime = new Date();
        System.out.println("本次任务执行的时间是" + executeTime);
    }
}
