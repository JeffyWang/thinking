package com.jeffy.Singleton;

public class PersonThread implements Runnable {

    public PersonThread(String name) {
        Person person = Person.getPerson();
        person.setName(name);
    }

    @Override
    public void run() {
        Person person = Person.getPerson();
        person.sayHello();
    }
}
