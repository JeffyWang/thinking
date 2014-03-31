package com.jeffy.Singleton;

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.equals("") || name != null) {
            synchronized (Person.class) {
                if (!name.equals("") || name != null) {
                    this.name = name;
                    System.out.println(name);
                }
            }
        }
    }

    private Person(){

    }

    public static Person person = null;

    public static Person getPerson() {
        if(person == null) {
            synchronized (Person.class) {
                if(person == null) {
                    person = new Person();
                }
            }
        }

        return person;
    }

    public void sayHello() {
        System.out.println("Hello! My name is " + name);
    }
}