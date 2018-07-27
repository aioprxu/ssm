package com.aiopr.proxy;

import com.mchange.v1.util.ArrayUtils;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * Created by Administrator on 2018/1/19.
 */
interface User{
    public String getName();
    public Integer getAge();
}
class  UserService implements User{

    public String getName() {
        System.out.println("-----getname------");
        return "Tom";
    }

    public Integer getAge() {
        System.out.println("------getage------");
        return 10;
    }
}
//JDK
class MyInvocationHandler implements InvocationHandler{

    private Object target;

    MyInvocationHandler(){
        super();
    }

    MyInvocationHandler(Object target){
        super();
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("getName".equals(method.getName())){
            System.out.println("=======before"+method.getName()+"=======");
            System.out.println(method);
            Object result = method.invoke(target,args);
            System.out.println(result);
            System.out.println("=======after"+method.getName()+"========");
            return result;
        }else {
            Object result = method.invoke(target,args);
            return result;
        }
    }
}

public class TestProxy {

    public static void main(String[] args) throws Exception {
        User userService = new UserService();
        //实现委托分发
        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
        //创建代理之后的实例
        User user = (User)Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),invocationHandler);
        user.getName();
//        int[] a = {1};
//        int[] b = {1,1};
//        Solution solution = new Solution();
//        int[] c = solution.intersect(a,b);
//        for (int i = 0; i < c.length; i++) {
//            System.out.println(c[i]);
//        }
//        List list = new ArrayList();
//        list.toArray();

    }
}




class T {

}
