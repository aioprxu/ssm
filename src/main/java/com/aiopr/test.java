package com.aiopr;

import java.util.*;

/**
 * 笔试题
 * Created by Administrator on 2018/3/27.
 */
public class test {
}

class Mai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int lh [] = new int [n];
        int ls [] = new int [n];
        int rh [] = new int [n];
        int rs [] = new int [n];
        int data [][] = new int [2<<9][2<<9];
        for(int i = 0;i<n;i++){
            lh[i]=in.nextInt();
        }
        for(int i = 0;i<n;i++){
            ls[i]=in.nextInt();
        }
        for(int i = 0;i<n;i++){
            rh[i]=in.nextInt();
        }
        for(int i = 0;i<n;i++){
            rs[i]=in.nextInt();
        }
        int max = 1;
        for(int i = 0;i<n;i++){
            for(int j=lh[i];j<rh[i];j++){
                for(int k = ls[i];k<rs[i];k++){
                    data[j][k]++;
                    if(data[j][k]>max)
                        max = data[j][k];
                }
            }
        }
        System.out.println(max);
    }
}


class Main {
    public static void main(String[] args) {
        System.out.println(0.06+0.05);
        Scanner in = new Scanner(System.in);

        int count = 0;
        int n = in.nextInt();
        int k = in.nextInt();
        for(int i = k;i<n;i++){
            count = count + n-i;
            int j = k+1;
            if(i>j) {
                for (; j <= n; j++) {
                    if (i % j >= k)
                        count++;
                }
            }
        }
        System.out.println(count);
    }
}


class SortTest {


    static class A implements Comparable<A> {
        private String name;
        private Integer order;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private Integer getOrder() {
            return order;
        }

        private void setOrder(Integer order) {
            this.order = order;
        }

        @Override
        public String toString() {
            return "name is " + name + " order is " + order;
        }

        @Override
        public int compareTo(A a) {
            return this.order.compareTo(a.getOrder());
        }

    }

    static class B {
        private String name;
        private String order;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String getOrder() {
            return order;
        }

        private void setOrder(String order) {
            this.order = order;
        }

        @Override
        public String toString() {
            return "name is " + name + " order is " + order;
        }
    }

    public static void main(String[] args) {

        //第一种方法示例：
        List<Integer> lists = new ArrayList<Integer>();
        lists.add(5);
        lists.add(2);
        lists.add(9);
        //lists中的对象String 本身含有compareTo方法，所以可以直接调用sort方法，按自然顺序排序，即升序排序
        Collections.sort(lists,(a,b)->(a.equals(b))?0:((a>b)?-1:1));

        //第一种方法示例：
        List<A> listA = new ArrayList<A>();
        A a1 = new A();
        a1.setName("a1");
        a1.setOrder(1);
        A a2 = new A();
        a2.setName("a2");
        a2.setOrder(2);
        listA.add(a1);
        listA.add(a2);
        //list中的对象A实现Comparable接口
        Collections.sort(listA);

        //第二种方法示例：
        List<B> listB = new ArrayList<B>();
        B b1 = new B();
        b1.setName("b1");
        b1.setOrder("a");
        B b2 = new B();
        b2.setName("b2");
        b2.setOrder("b");
        listB.add(b1);
        listB.add(b2);
        //根据Collections.sort重载方法来实现
        listB.sort(Comparator.comparing(B::getOrder).thenComparing(B::getOrder));
//        (Comparator.comparing((Obj o) -> o.first).thenComparing(o -> o.second).thenComparingInt(o -> o.third));
        System.out.println(lists);
        System.out.println(listA);
        System.out.println(listB);
    }
}
