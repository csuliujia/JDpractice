package com.jd.SimpleThreadPoolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 根据任务来临的需要决定是否创建新的线程
   如果来了新任务又没有空闲线程，它就会新建一个线程
   当线程池大小超过了处理任务所需的线程，就会回收部分空闲（一般是60秒无执行）的线程
   */
public class CachedThreadPool {

        public static void main(String[] args) {

            ExecutorService executorService = Executors.newCachedThreadPool();

            for(int i = 1; i <= 10; i++){
                //匿名内部类调用，必须为final类型
                final int count = i;

                executorService.submit(new Runnable(){

                    public void run() {
                        System.out.println("线程："+Thread.currentThread()+"负责了第"+count+"次任务");
                    }

                });
                //下面这行代码注释的话，线程池会新建10个线程
                // 不注释的话，因为会复用老线程，不会产生10个线程
			    //Thread.sleep(1);
            }
        }
}
