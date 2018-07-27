package com.aiopr.redis;

import java.util.concurrent.atomic.AtomicInteger;

public class SecKill implements Runnable{

//    AtomicInteger shangpin = new AtomicInteger(500);
    private RedisUtil redisUtil = new RedisUtil();
    private int shangpin = 500;
    @Override
    public void run() {
        RedisTest.tryGetDistributedLock(redisUtil.getJedis(),
                Thread.currentThread().getName(),Thread.currentThread().getName(),100000000);
        if (shangpin>0) {
            shangpin--;
            System.out.println(Thread.currentThread().getName() + "获得了锁" + shangpin);
        }
        else System.out.println("没货了");
        RedisTest.tryReleaseLock(redisUtil.getJedis(),
                Thread.currentThread().getName(),Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        SecKill secKill = new SecKill();
        for(int i = 0;i<1000;i++){
            new Thread(secKill).start();
        }
    }
}
