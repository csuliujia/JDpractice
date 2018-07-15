package com.jd.SimpleThreadTest;

public class RunTask {
    public static void main(String[] args) {
        //测试Runnable
        MyRunMethod t1 = new MyRunMethod();
        new Thread(t1).start();//同一个t1，如果在Thread中就不行，会报错
        new Thread(t1).start();
        new Thread(t1).start();

    }
}
