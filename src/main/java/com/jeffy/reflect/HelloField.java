package com.jeffy.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * Created by Administrator on 14-4-17.
 */
public class HelloField {
    public static void main(String[] args) throws Exception {
//        fieldPerson();
        fieldArray();
    }

    public static void fieldPerson() throws Exception {
        Class<?> demo = Class.forName("com.jeffy.reflect.Person");
        Object obj = demo.newInstance();

        Field field = demo.getDeclaredField("name");
        field.setAccessible(true);
        field.set(obj,"jeffy");
        System.out.println(field.get(obj));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Field[] fields = demo.getDeclaredFields();
//        for(int i = 0; i < fields.length; i ++) {
//            fields[i].setAccessible(true);
//            fields[i].set(obj, "a" + i);
//               System.out.println(fields[i].get(obj));
//        }
        System.out.println("field0's name is : " + fields[0].getName());
        System.out.println("field0's type is : " + fields[0].getType());
        System.out.println("field1's name is : " + fields[1].getName());
        System.out.println("field1's type is : " + fields[1].getType());
    }

    public static void fieldArray() {
        int[] temp = {1,2,3,4,5};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("array type : " + demo.getName());
        System.out.println("array length : " + Array.getLength(temp));
        System.out.println("first param : " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("change the first param " + Array.get(temp, 0));
    }
}
