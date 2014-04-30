package com.jeffy.reflect;

/**
 * Created by Administrator on 14-4-18.
 */
public class ClassLoader {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.getClass().getClassLoader().getClass().getName());
    }
}

class Test {

}
