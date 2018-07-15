package com.jd.SimpleThreadTest;

/* 实现Runnable接口比继承Thread类所具有的优势：
   1.适合多个相同的程序代码的线程去处理同一个资源
   2.可以避免java中的单继承的限制
   3.增加程序的健壮性，代码可以被多个线程共享，代码和数据独立  */

public class MyRunMethod implements Runnable {
    private int ticket = 10;

    //记得要资源公共，要在run方法之前加上synchronized关键字，要不然会出现抢资源的情况
    public  synchronized void  run() {
        for (int i = 0; i <10; i++) {
            if (this.ticket>0) {
                System.out.println("卖票：ticket"+this.ticket--);
            }
        }
    }
}
