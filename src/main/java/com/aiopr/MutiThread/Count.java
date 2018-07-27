package com.aiopr.MutiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class Count implements Runnable {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);//static保证没有副本

    @Override
    public void run() {
        synchronized (this) {
            while (atomicInteger.get()<1000) {
                atomicInteger.getAndIncrement();
                System.out.println("当前线程" + Thread.currentThread().getName() + ":" + atomicInteger);
            }
        }
    }

    public static void main(String[] args) {
        //创建五个线程实例并启动
        for (int i = 1; i < 6; i++) {
            Thread count = new Thread(new Count());
            count.start();
        }
    }
}
