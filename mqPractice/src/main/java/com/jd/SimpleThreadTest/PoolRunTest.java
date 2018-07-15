package com.jd.SimpleThreadTest;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class PoolRunTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        //测试Runnable
        MyRunMethod t1 = new MyRunMethod();

        //注意对比区别：多线程，共享资源(必须有针对资源进行的操作)，否则还是每条线程执行全部任务执行一遍
        for(int i = 0; i < 4; i++){
            executorService.submit(t1);
        }

        executorService.shutdown();//当线程池中线程执行完所有任务，所有线程处于空闲状态时，干掉所有线程，程序自动结束

        /*//注意对比区别：多线程，但不共享资源
        for(int i = 0; i < 4; i++){
            executorService.submit(new MyRunMethod());
        }*/

        /*//注意对比区别：未启动多线程，实际为单线程
        executorService.submit(t1);*/
    }
}
