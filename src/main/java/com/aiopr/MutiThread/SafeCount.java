package com.aiopr.MutiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeCount implements Runnable {
    private AtomicInteger count = new AtomicInteger(0);
    private int threadCount = 0;//线程编号
    private static int num = 1;

    private synchronized void increase() {
        while (count.get()<1000) {
            count.getAndIncrement();
            System.out.println("当前线程"+Thread.currentThread().getName()+":"+count);
        }
    }

    @Override
    public void run() {
        while (true) {
                this.increase();
        }
    }

    public static void main(String[] args) {
        //创建五个线程实例并启动
        for (int i = 1; i < 6; i++) {
            Thread mySafeThread = new Thread(new SafeCount());
            mySafeThread.start();
        }
    }
}
