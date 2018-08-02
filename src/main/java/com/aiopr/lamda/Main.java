package com.aiopr.lamda;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/1/31.
 */
public class Main {
    public static void main(String[] args) {
        TestLambada testLambada = new TestLambada();
        System.out.println(testLambada.useInterface(x->"sss"));
    }

}
class TestLambada{
    public String useInterface(Interface i){
        return i.function(()->"this is lambda");
    }
}
//    public static void main(String[] args) {
//        AtomicInteger j = new AtomicInteger(5);
//        Integer[] a = {2, 3, 4, 2, 5, 6, 6};
//        List<Integer> list = new ArrayList<>(Arrays.asList(a));
//        System.out.println(add(list));
//
//
//        ExecutorService executorService = Executors.newFixedThreadPool(20);

//        for (int i = 0; i < 20; i++) {
//            executorService.execute(new Thread(() -> {
//                System.out.println("hhh" + Thread.currentThread()
//                        .getName() + "ssss" + j.getAndIncrement());
//                System.out.println("jjjjjjj");
//            }));
//        }
//
//    }

    /**
     * @param list
     * @return 和
     */
//    public static int add(List<Integer> list) {
////        list.parallelStream().forEach(System.out::println);
//        list.parallelStream().forEachOrdered(n -> System.out.println(n));
//        return list.parallelStream().mapToInt(a -> a).sum();
//    }
//}


