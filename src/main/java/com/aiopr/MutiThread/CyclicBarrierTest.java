package com.aiopr.MutiThread;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CyclicBarrierTest implements Runnable{

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4,this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        new CyclicBarrierTest().calculate();
    }

    @Override
    public void run() {
        int result = 0;
        for(Integer x : map.values()) {
            result+=x;
        }
        map.put(Thread.currentThread().getName()+"result_",result);
        System.out.println(map.toString());
    }

    private void calculate() {
        for(int i=0;i<4;i++) {
            executor.execute(()->{
                map.put(Thread.currentThread().getName(),10);
                try {
                    System.out.println(Thread.currentThread().getName()+"is waiting");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"is working");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
