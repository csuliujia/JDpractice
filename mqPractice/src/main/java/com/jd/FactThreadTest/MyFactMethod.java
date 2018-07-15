package com.jd.FactThreadTest;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyFactMethod implements Runnable{
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;

    public MyFactMethod(List<String> list) {
        this.list = list;
    }

    public MyFactMethod(Set<String> set) {
        this.set = set;
    }

    public MyFactMethod(Map<String, String> map) {
        this.map = map;
    }

    public void run() {
        for(int i = 0; i < 10; i++){
           /* addSet(list.get(i));*/
           /* String str = list.get(i);
            boolean flag = set.add(str);
            System.out.println(flag);*/

           if (list.size() > 0){
               System.out.println(Thread.currentThread().getId() +
                       Thread.currentThread().getName());
               list.remove(i);
           }



        }
       /* this.map.put("uid", String.valueOf(set.size()));
        System.out.println(Thread.currentThread().getId() +
                Thread.currentThread().getName()+"============>uid" + this.map.get("uid"));*/

    }

    /*public synchronized void addSet(String ele){

            this.set.add(ele);
    }*/
}
