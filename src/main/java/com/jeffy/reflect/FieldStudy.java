package com.jeffy.reflect;

import org.omg.DynamicAny._DynEnumStub;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 14-4-18.
 */
public class FieldStudy {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.jeffy.reflect.Person");

        Object obj = clazz.newInstance();
        System.out.println(obj);

        Field[] fields = clazz.getDeclaredFields();
        System.out.println(fields.length);
        for(int i = 0; i < fields.length; i ++) {
            System.out.println(fields[i].getName());
        }

        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(obj, "jeffy");
        System.out.println(obj);
    }
}
