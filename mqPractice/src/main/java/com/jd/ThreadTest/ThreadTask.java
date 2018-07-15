package com.jd.ThreadTest;

public class ThreadTask {

    public static void main(String[] args) {
        Mythread mythread1 = new Mythread("mythread1");
        Mythread mythread2 = new Mythread("mythread2");
        mythread1.start();
        mythread2.start();

    }

}
