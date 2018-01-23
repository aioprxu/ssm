package com.aiopr;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/11/28.
 */
public class TransientTest {


    static{
        System.out.println("main static loading");
    }

    public static void main(String[] args) {
        Write write = new Write();
        new Thread(write,"1  :").start();
        new Thread(write,"2   :").start();
        new Thread(write,"3  :").start();

    }

}

class Write implements Runnable{

//    private int a = 0;

    private AtomicInteger a = new AtomicInteger(0);

    int ticket = 100;

    public void run() {

        synchronized (this) {
            while (ticket > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + --ticket);
            }
        }
    }

    private int getA(){
        return a.getAndIncrement();
    }
}

class A{
    public A(){
        System.out.println("A loading...");
    }

    static{
        System.out.println("static loading...");
    }

    public static void write(){
        System.out.println("------------------");
    }
}