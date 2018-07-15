package com.jd.FactThreadTest;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolFactTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("c");
        list.add("a");
        list.add("c");
        list.add("d");

        MyFactMethod myFactMethod = new MyFactMethod(list);
        //注意对比区别：多线程，共享资源
        for(int i = 0; i < 4; i++){
            executorService.submit(myFactMethod);
        }
    }
}
