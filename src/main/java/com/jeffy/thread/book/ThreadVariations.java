package com.jeffy.thread.book;

/**
 * Created by Administrator on 14-4-1.
 */
public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}

class InnerThread1 {
    private Inner inner;

    public InnerThread1(String name) {
        inner = new Inner(name);
    }

    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }

        public void run() {
            System.out.println(this);
        }

        public String toString() {
            return "inner thread1's name is " + getName();
        }
    }
}

class InnerThread2 {
    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {
            public void run() {
                System.out.println(this);
            }

            public String toString() {
                return "inner thread2's name is " + getName();
            }
        };

        t.start();
    }
}

class InnerRunnable1 {
    private Inner inner;

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }

    private class Inner implements Runnable {
        Thread t;

        Inner(String name) {
            t = new Thread(this,name);
            t.start();
        }

        public String toString() {
            return "inner runnable1's name is " + t.getName();
        }

        @Override
        public void run() {
            System.out.println(this);
        }
    }
}

class InnerRunnable2 {
    private Thread t;

    public InnerRunnable2(String name) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
            }

            public String toString() {
                return "inner runnable2's name is " + Thread.currentThread().getName();
            }
        }, name);
        t.start();
    }
}

class ThreadMethod {
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if(t == null) {
            t = new Thread(name) {
                public void run() {
                    System.out.print(this);
                }

                public String toString() {
                    return "thread method's name is " + getName();
                }
            };
            t.start();
        }
    }
}