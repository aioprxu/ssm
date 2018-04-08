package com.aiopr.proxy;

import com.mchange.v1.util.ArrayUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
class UserService implements User{

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
//CGLIB
class MyProxy implements MethodInterceptor {



    public  UserService getproxy(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(this);
        UserService userService=(UserService) enhancer.create();
        return userService;
    }

    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("------before--------");
        String str = (String)methodProxy.invokeSuper(proxy,args);
        System.out.println("------after---------");
        return str;
    }
}
public class TestProxy {

    public static void main(String[] args) throws Exception {
        //得到代理类实例
//        MyProxy myProxy = MyProxy.class.newInstance();
        //得到动态代理类
//        UserService userService = myProxy.getproxy();
        //创建真实对象实例
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

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map map = new HashMap();
        List list = new LinkedList();

        int[] nums = new int[nums2.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    nums2[j] = -1;
                    nums[index++] = nums1[i];
                    break;
                }
            }
        }
        if (nums1.length == 0 || nums2.length == 0)
            nums = new int[0];
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i]=nums[i];
        }
        return nums;

    }
}


class T {

}
