package com.jeffy.reflect;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Administrator on 14-4-16.
 */
public class Hello {
    public static void main(String[] args) throws Exception {
        System.out.println("===========================");

        Class<?> demo = Class.forName("com.jeffy.reflect.Person");

        Constructor<?> cons[] = demo.getConstructors();
        System.out.println(cons.length);

        Person p1 = (Person) cons[3].newInstance();
        Person p2 = (Person) cons[1].newInstance("jeffy");
        Person p3 = (Person) cons[0].newInstance(24);
        Person p4 = (Person) cons[2].newInstance("jeffy","24");

        for(int i = 0;i < cons.length; i ++) {
            System.out.println(cons[i]);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(int i = 0; i < cons.length; i ++) {
            Class<?> p[] = cons[i].getParameterTypes();
            int mo = cons[i].getModifiers();
            System.out.print("construction method " + Modifier.toString(mo) + " " + cons[i].getName());
            System.out.print("(");
            for(int j = 0; j < p.length; j ++) {
                System.out.print(p[j].getName() + " args" + i);
                if(j < p.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(") {}");
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Method methods[] = demo.getMethods();
        for(int i = 0; i < methods.length; i ++) {
            Class<?> returnType = methods[i].getReturnType();
            Class<?> para[] = methods[i].getParameterTypes();
            int modifier = methods[i].getModifiers();
            System.out.print(Modifier.toString(modifier) + " " + returnType.getName() + " " + methods[i].getName() + " ");
            System.out.print("(");
            for(int j = 0; j < para.length; j ++) {
                System.out.print(para[j].getName() + " arg" + j);
                if(j < para.length - 1) {
                    System.out.print(", ");
                }
            }
            Class<?> execeptions[] = methods[i].getExceptionTypes();
            if(execeptions.length > 0) {
                System.out.print(") throws ");
                for(int k = 0; k < execeptions.length; k ++) {
                    System.out.print(execeptions[k].getName() + " ");
                    if(k < execeptions.length - 1) {
                        System.out.print(", ");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

    }
}

class Person {
    private String name;
    private String age;

    public Person() {

    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = String.valueOf(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
