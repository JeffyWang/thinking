package com.jeffy.reflect.loadbean;

/**
 * Created by Administrator on 14-4-18.
 */
public class Student {
    private String name;
    private int age;
    private int classNumber;

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classNumber=" + classNumber +
                '}';
    }
}

class Jeffy extends Student {
    public Jeffy() {
       super();
    }

    public void say(){
        System.out.println("1.My name's " + this.getName() + ", I'm " + this.getAge() + " and I'm study in class " + this.getClassNumber());
    }
}

class Amy extends Student {
    public Amy() {
        super();
    }

    public void say(){
        System.out.println("2.My name's " + this.getName() + ", I'm " + this.getAge() + " and I'm study in class " + this.getClassNumber());
    }
}