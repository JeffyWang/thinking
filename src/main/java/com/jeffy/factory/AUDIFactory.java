package com.jeffy.factory;

/**
 * Created by Administrator on 14-3-31.
 */
public class AUDIFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new AUDI();
    }
}
