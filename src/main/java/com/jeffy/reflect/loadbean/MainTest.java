package com.jeffy.reflect.loadbean;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Administrator on 14-4-18.
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        System.out.println("############### init ###############");
        Analysis analysis = new Analysis();
        List<Person> personList = Analysis.getPERSONS();
        for(Person p : personList) {
            System.out.println(p);
        }

        System.out.println("############### create ###############");
        Class<?> clazz0 = Class.forName(personList.get(0).getRef());
        Class<?> father0 = clazz0.getSuperclass();
        Object obj0 = clazz0.newInstance();

        Field nameField = father0.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj0, "jeffy");
        Field ageField = father0.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(obj0, 24);
        Field classNumberField = father0.getDeclaredField("classNumber");
        classNumberField.setAccessible(true);
        classNumberField.set(obj0, 1);
        Jeffy jeffy = (Jeffy) obj0;
        System.out.println(obj0);
        jeffy.say();
    }
}
