package com.aiopr.callback;


import java.io.InputStream;
import java.util.Timer;

/**
 * Created by Administrator on 2018/1/22.
 */
interface Callback{
    public void solve(String result);
}
class Wang implements Callback{

    private Li li;

    public Wang(Li li){
        this.li = li;
    }

    @Override
    public void solve(String result) {
        System.out.println("答案是："+result);
    }

    public void askQuestion(final String question){
        //这里用一个线程就是异步，
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 小王调用小李中的方法，在这里注册回调接口
                 * 这就相当于A类调用B的方法C
                 */
                try {
                    Thread.sleep(100);
                    li.executeMessage(Wang.this, question);
                    play();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        //小网问完问题挂掉电话就去干其他的事情了，诳街去了

    }

    public void play(){
        System.out.println("我去玩了。。。。");
    }
}
class Li {
    public void executeMessage(Callback callback,String question){
        System.out.println("小王问的问题--->" + question);

        //模拟小李办自己的事情需要很长时间
        for(int i=0; i<10000;i++){

        }

        /**
         * 小李办完自己的事情之后想到了答案是2
         */
        String result = "答案是2";

        /**
         * 于是就打电话告诉小王，调用小王中的方法
         * 这就相当于B类反过来调用A的方法D
         */
        callback.solve(result);

    }
}

class A{
    A(){}
    A(String s){
        System.out.println("aaaaaaaaaa");
    }
}
class B extends A{
    B(){
        System.out.println("bbbbbbbbbbbbb");
    }
}
public class CallbackTest {

    public static void main(String[] args) {
        A a = new A("sss");
        B b = new B();
    }

}
