package com.jd.SimpleThreadTest;

public class RunTask {
    public static void main(String[] args) {
        //测试Runnable
        MyRunMethod t1 = new MyRunMethod();
        new Thread(t1, "thread1").start();//同一个t1，如果在Thread中就不行，会报错
        new Thread(t1, "thread2").start();
        new Thread(t1, "thread3").start();

       /* //注意对比区别:不会资源共享
        MyRunMethod t1 = new MyRunMethod();
        MyRunMethod t2 = new MyRunMethod();
        new Thread(t1, "thread1").start();
        new Thread(t2, "thread2").start();*/

    }
}
