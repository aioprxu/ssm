package com.aiopr.aop;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Administrator on 2018/1/20.
 */
interface UserService{
    public String getName (int id);
    public Integer getAge (int id);
}
interface User{
    public void eat();
}
@Component
class UserImp implements User{

    public void eat() {
        System.out.println("吃");
    }
}
@Component
class UserServiceImp implements UserService {



    private User user;

    public User getUser() {
        return user;
    }

    @Autowired
    public void setUser(User user) {
        this.user = user;
    }

    //    ApplicationContext applicationContext = new
//            ClassPathXmlApplicationContext("spring/application.xml");
//    {
//        user = applicationContext.getBean(User.class);
//    }
    public String getName(int id) {
        user.eat();
        System.out.println("-----getname------");
        return "Tom";
    }

    public Integer getAge(int id) {
        System.out.println("------getage------");
        return 10;
    }
}
@Aspect
@Component
class loggingAspect{

    @Before("execution(public String *.getName(int))")
    public void beforeMethod(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("-----------before---------"+method+args);
    }

    @After("execution(public String *.getName(int))")
    public void afterMethod(){
        System.out.println("-----------after----------");
    }
}
class A{
    private static A single = new A();
    private A () {}
    public static A getInstance(){return single;}
}
public class AopTest {

    static class listComparator implements Comparator{

        private static listComparator single = new listComparator();

        listComparator(){
            System.out.println("I'm begin");
        }

        public synchronized static listComparator getInstance(){
            System.out.println("hhhh");
            return listComparator.single;
        }

        @Override
        public int compare(Object o1, Object o2) {
            if(o1==o2)
                return 0;
            else return 1;
        }
    }


    public static void main(String[] args)  {

        List list = new ArrayList();



        Object[] o = {new Object()};
        Arrays.sort(o);
        Collections.sort(list,listComparator.getInstance());

        System.out.println(listComparator.getInstance()==(listComparator.getInstance()));

        System.out.println(A.getInstance()==A.getInstance());

//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring/applicationcontext.xml");
//        UserService userService = applicationContext.getBean(UserService.class);
//        UserService userService1 = applicationContext.getBean(UserService.class);
//        if(userService == userService1) System.out.println("单例");
//        else System.out.println("多例");
//        String result = userService.getName(1);
//        System.out.println(result);
//        DataSource dataSource = applicationContext.getBean(DataSource.class);
//        System.out.println(dataSource.getConnection());



    }
}
