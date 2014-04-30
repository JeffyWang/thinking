package com.jeffy.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 14-4-18.
 */
public class Invocation {
    public static void main(String[] args) {
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject sub = (Subject) demo.bind(new SubjectImpl());
        String info = sub.say("jeffy", 24);
        System.out.println(info);
    }
}

interface Subject {
    public String say(String name, int age);
}

class SubjectImpl implements Subject {
    @Override
    public String say(String name, int age) {
        return name + " " + age;
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj = null;

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object temp = method.invoke(this.obj, args);
        return temp;
    }
}
