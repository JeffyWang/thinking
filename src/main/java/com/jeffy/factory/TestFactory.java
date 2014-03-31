package com.jeffy.factory;

/**
 * Created by Administrator on 14-3-31.
 */
public class TestFactory {
    public static void main(String[] args) {
        CarFactory carFactory = null;

        carFactory = new BMWFactory();
        Car car = carFactory.createCar();
        car.doCar();

        carFactory = new AUDIFactory();
        Car AUDI = carFactory.createCar();
        AUDI.doCar();
    }
}
