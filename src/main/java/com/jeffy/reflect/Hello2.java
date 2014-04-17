package com.jeffy.reflect;

import static java.lang.Class.forName;

/**
 * Created by Administrator on 14-4-16.
 */
public class Hello2 {
    public static void main(String[] args) throws Exception {
        Class<?> demo = Class.forName("com.jeffy.reflect.Student");
        Class<?> intes[] = demo.getInterfaces();

        for(int i = 0; i < intes.length; i ++) {
            System.out.println("interface implements : " + intes[i].getName());
        }

        System.out.println("-----------------------------------------------");

        Class<?> demo2 = Class.forName("com.jeffy.reflect.Person");
        Class<?> father = demo2.getSuperclass();
        System.out.println("person's father is : " + father.getName());
    }
}

interface China{
    public static final String name="jeffy";
    public static  int age=24;
    public void sayChina();
    public void sayHello(String name, int age);
}

class Student implements China {
    private String school;

    public Student() {

    }

    public Student(String school) {
        this.school = school;
    }

    @Override
    public void sayChina() {
        System.out.println("Hello China~~!");
    }

    @Override
    public void sayHello(String name, int age) {
        System.out.println(name  + "Hello~~!, I'm " + age + " years old.");
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
