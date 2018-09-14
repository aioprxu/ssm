package com.aiopr.lock;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/2/1.
 */
public class MyLock implements Lock {

    private volatile boolean lockflag = false;
    private int count;
    private Thread threadby = null;
    @Override
    public synchronized void lock() {
        if(lockflag && threadby != Thread.currentThread()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lockflag = true;
        threadby = Thread.currentThread();
        count++;

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public synchronized void unlock() {

        if(threadby == Thread.currentThread()){
            count--;
            if(count==0) {
                lockflag = false;
                notify();
            }
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }



}


class Test {
    public static void main(String[] args) {
        System.out.println("main");
        Thread a = new Thread(()->{
            try {
                Thread.currentThread().join();
                System.out.println("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread b = new Thread(()->{
            try {
                Thread.currentThread().join();
                System.out.println("b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        b.start();
        a.start();
    }
}