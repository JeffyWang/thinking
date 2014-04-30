package com.jeffy.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * Created by Administrator on 14-4-17.
 */
public class HelloField {
    public static void main(String[] args) throws Exception {
        fieldPerson();
//        fieldArray();
//        changeArrayLength();
    }

    //get the class param name and type
    public static void fieldPerson() throws Exception {
        Class<?> demo = Class.forName("com.jeffy.reflect.Person");
        Object obj = demo.newInstance();

        Field field = demo.getDeclaredField("name");
        field.setAccessible(true);
        field.set(obj,"jeffy");
        System.out.println(field.get(obj));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Field[] fields = demo.getDeclaredFields();
        for(int i = 0; i < fields.length; i ++) {
            fields[i].setAccessible(true);
            fields[i].set(obj, "a" + i);
               System.out.println(fields[i].get(obj));
        }
        System.out.println("field0's name is : " + fields[0].getName());
        System.out.println("field0's type is : " + fields[0].getType());
        System.out.println("field1's name is : " + fields[1].getName());
        System.out.println("field1's type is : " + fields[1].getType());
    }

    //change the array param
    public static void fieldArray() {
        int[] temp = {1,2,3,4,5};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("array type : " + demo.getName());
        System.out.println("array length : " + Array.getLength(temp));
        System.out.println("first param : " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("change the first param " + Array.get(temp, 0));
    }

    //change the array length
    public static void changeArrayLength() {
        int[] temp = {1,2,3,4,5,6,7,8,9};
        int[] newTemp = (int[]) arrayInc(temp, 15);
        print(newTemp);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

        String[] atr = {"a", "b", "c"};
        String[] newAtr = (String[]) arrayInc(atr, 8);
        print(newAtr);
    }

    public static Object arrayInc(Object obj, int length) {
        Class<?> arr = obj.getClass().getComponentType();
        Object newArr = Array.newInstance(arr, length);
        int co = Array.getLength(obj);

        System.arraycopy(obj, 0, newArr, 0, co);
        return newArr;
    }

    public static void print(Object obj) {
        Class<?> c = obj.getClass();
        if(!c.isArray()) {
            return;
        }
        System.out.println("the array's length is : " +Array.getLength(obj));
        for(int i =0; i < Array.getLength(obj); i ++) {
            System.out.print(Array.get(obj, i) + " ");
        }
    }
}
