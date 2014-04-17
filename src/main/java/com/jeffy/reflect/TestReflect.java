package com.jeffy.reflect;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 14-4-16.
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;

        demo1 = Class.forName("com.jeffy.reflect.Demo");
        demo2 = new Demo().getClass();
        demo3 = Demo.class;

        System.out.println("demo1's name : " + demo1.getName());
        System.out.println("demo2's name : " + demo2.getName());
        System.out.println("demo3's name : " + demo3.getName());
    }
}

class Demo {
    public Demo() {
        System.out.println(this.getClass().getName());
    }
}
