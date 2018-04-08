package com.aiopr.Single;

/**
 * Created by Administrator on 2018/1/28.
 */


public class SingleTon {

    // 利用静态内部类特性实现外部类的单例
    private static class SingleTonBuilder {
        private static SingleTon singleTon = new SingleTon();
    }

    // 私有化构造函数
    private SingleTon() {

    }

    public static SingleTon getInstance() {
        return SingleTonBuilder.singleTon;
    }

    public static void main(String[] args) {
        System.out.println(getInstance()==getInstance());
    }
}
