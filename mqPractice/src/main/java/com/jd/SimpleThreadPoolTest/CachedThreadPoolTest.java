package com.jd.SimpleThreadPoolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolTest {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 1; i <= 10; i++){
            //匿名内部类调用，必须为final类型
            final int count = i;

            executorService.submit(new Runnable(){
                private int ticket = 10;

                public synchronized void run() {
                    System.out.println("线程："+Thread.currentThread()+"负责了第"+count+"次任务");
                    for (int i = 0; i < 10; i++) {
                        if (this.ticket>0) {
                            System.out.println("卖票：ticket"+this.ticket--);
                        }
                    }
                }
            });
            //下面这行代码注释的话，线程池会新建10个线程
            // 不注释的话，因为会复用老线程，不会产生10个线程
            //Thread.sleep(1);
        }
    }
}
