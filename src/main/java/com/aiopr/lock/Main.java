package com.aiopr.lock;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;

/**
 * Created by Administrator on 2018/2/1.
 */
public class Main {
    public static void main(String[] args) {

        Lock lock = new MyLock();
        A a = new A();
        B b = new B();
//        new Thread(()->{lock.lock();
////            try {
////                Thread.sleep(10);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//            a.a();lock.unlock();}).start();
//        new Thread(()->{lock.lock();b.b();lock.unlock();}).start();
    }
}
class A {
    public void a(){
        System.out.println("a");
    }
}
class B {
    A a = new A();
    public void b(){
        a.a();
        System.out.println("b");
    }
}