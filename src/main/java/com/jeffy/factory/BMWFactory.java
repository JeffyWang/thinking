package com.jeffy.factory;

/**
 * Created by Administrator on 14-3-31.
 */
public class BMWFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new BMW();
    }
}
