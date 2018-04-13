package com.aiopr.customer;

/**
 * 生产者消费者模式
 * Created by Administrator on 2018/2/3.
 */

class A  extends ThreadLocal<Integer> {

    @Override
    protected Integer initialValue() {
        return new Integer(0);
    }

    public int getNext(){
        Integer value=super.get();
        value++;
        super.set(value);
        return value;
    }

}
public class CustomerTest {
    public static void main(String[] args) {

//        A a = new A();
//        new Thread(()->{
//            while (true) {
//                System.out.println(Thread.currentThread().getName() + "hhh" + a.getNext());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        new Thread(()->{
//            while (true) {
//                System.out.println(Thread.currentThread().getName() + "hhh" + a.getNext());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        new Thread(()->{
//            while (true) {
//                System.out.println(Thread.currentThread().getName() + "hhh" + a.getNext());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//

    }
}
class Customer implements Runnable{

    private mall mall;

    public Customer (mall mall){
        this.mall = mall;
    }

    @Override
    public void run() {
        mall.get();
    }
}
class Producer implements Runnable{

    private mall mall;

    public Producer (mall mall){
        this.mall = mall;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mall.put();
        }
    }
}
class mall{
    private volatile int iphone;

    public synchronized void put(){
        while (iphone>=10) {
            System.out.println("full");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.gc();
        }
        {
            iphone++;
            System.out.println(Thread.currentThread().getName()+"put one!!!还剩："+iphone);
            notifyAll();
        }
    }

    public synchronized void get(){
        while (iphone<=0) {
            System.out.println("over");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        {
            notifyAll();
            iphone--;
            System.out.println(Thread.currentThread().getName()+"GET ONE!!!haisheng:"+iphone);
        }
    }
}