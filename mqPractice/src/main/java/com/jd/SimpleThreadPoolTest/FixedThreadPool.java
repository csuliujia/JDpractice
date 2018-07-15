package com.jd.SimpleThreadPoolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 固定数量的线程池，每提交一个任务就是一个线程，直到达到线程池的最大数量
   然后后面进入等待队列直到前面的任务完成才继续执行 */
public class FixedThreadPool {
        public static void main(String[] args) throws Exception {

            ExecutorService executorService = Executors.newFixedThreadPool(4);

            for(int i = 1;i <= 10;i++){
                final int count = i;

                executorService.submit(new Runnable(){

                    public void run() {
                        System.out.println("线程："+Thread.currentThread()+"负责了第"+count+"次任务");
                    }

                });
               Thread.sleep(1000);
            }

        }

}
