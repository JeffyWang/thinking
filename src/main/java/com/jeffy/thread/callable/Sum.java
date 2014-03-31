package com.jeffy.thread.callable;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 14-3-31.
 */
public class Sum implements Callable<String> {
    private int sum;

    public Sum(int num1, int num2) {
        sum =  num1 + num2;
    }

    @Override
    public String call() throws Exception {
        return "the sum is : " + sum;
    }
}
