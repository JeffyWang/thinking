package com.jeffy.reflect;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 14-4-17.
 */
public class Hello3 {
    public static void main(String[] args) throws Exception {
        Class<?> demo = Class.forName("com.jeffy.reflect.Person");
        Object obj = demo.newInstance();
        setter(obj, "Name", "jeffy", String.class);
        setter(obj, "Age", "24", String.class);
        getter(obj, "Name");
        getter(obj, "Age");
    }

    public static void getter(Object obj, String att) throws Exception {
        Method method = obj.getClass().getMethod("get" + att);
        System.out.println(method.invoke(obj));
    }

    public static void setter(Object obj, String att, Object value, Class<?> type) throws Exception {
        Method method = obj.getClass().getMethod("set" + att, type);
        method.invoke(obj, value);
    }
}
