package com.jd.SimpleThreadTest;

/* 实现Runnable接口比继承Thread类所具有的优势：
   1.适合多个相同的程序代码的线程去处理同一个资源
   2.可以避免java中的单继承的限制
   3.增加程序的健壮性，代码可以被多个线程共享，代码和数据独立  */

import static java.lang.Thread.sleep;

public class MyRunMethod implements Runnable {
    private int ticket = 10;

    //记得资源公共时要给run方法内操作资源的方法上synchronized关键字，要不然会出现抢资源的情况
    //如果直接在run方法上加上synchronized关键字，会变成单条线程执行完该资源全部任务！
    public void run() {
        for (int i = 0; i < 10; i++) {

           buyTicket();

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       /* //注意对比区别，下列表示每个线程只卖一张票，一共只卖了四张(四个线程)
        buyTicket();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }

    //针对资源进行的操作
    public synchronized void buyTicket(){

        if (ticket>0) {
                System.out.println(Thread.currentThread().getId() +
                        Thread.currentThread().getName() + "卖票：ticket"+ticket--);
        }

    }
}
