package com.aiopr.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CGLIBProxy {
    public String getName() {
        System.out.println("-----getname------");
        return "Tom";
    }

    public Integer getAge() {
        System.out.println("------getage------");
        return 10;
    }

    //CGLIB
    class MyProxy implements MethodInterceptor {

        private Enhancer enhancer =new Enhancer();

        public  Object getproxy(){
            enhancer.setSuperclass(UserService.class);
            enhancer.setCallback(this);
            return enhancer.create();
        }

        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("------before--------");
            return  (String)methodProxy.invokeSuper(proxy,args);
        }
    }


    public static void main(String[] args) throws Exception {
        //得到代理类实例
        MyProxy myProxy = new CGLIBProxy().new MyProxy();
//        得到动态代理类
        UserService userService = (UserService) myProxy.getproxy();
        //创建真实对象实例
//        User userService = new UserService();
//        //实现委托分发
//        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
//        //创建代理之后的实例
//        User user = (User) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
//                userService.getClass().getInterfaces(), invocationHandler);
        System.out.println(userService.getName());
    }
}


