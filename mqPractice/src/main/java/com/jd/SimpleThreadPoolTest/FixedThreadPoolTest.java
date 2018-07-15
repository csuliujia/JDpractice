package com.jd.SimpleThreadPoolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

/* 固定数量的线程池，每提交一个任务就是一个线程，直到达到线程池的最大数量
   然后后面进入等待队列直到前面的任务完成才继续执行 */
public class FixedThreadPoolTest {
        public static void main(String[] args) throws Exception {

            ExecutorService executorService = Executors.newFixedThreadPool(4);

            for(int i = 0; i < 4; i++){
                executorService.execute(new Runnable(){
                    private int ticket = 10;

                    public void  run() {
                        for (int i = 0; i < 10; i++) {
                            if (this.ticket>0) {
                                System.out.println(Thread.currentThread().getId() +
                                        "卖票：ticket"+this.ticket--);
                            }

                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                });
            }
        }
}
