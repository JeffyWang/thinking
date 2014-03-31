package com.jeffy.Singleton;

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = Person.getPerson();
        p1.setName("jeffy");
        System.out.println(p1.getName());
        Person p2 = Person.getPerson();
        p2.setName("jeffy");
        System.out.println(p2.getName());

        p1.sayHello();
        p2.sayHello();

        if(p1 == p2)
            System.out.println("this is the same instants");
        else if(p1 != p2)
            System.out.println("this is not the same instants");
        else
            System.out.println("system error");
    }
}
