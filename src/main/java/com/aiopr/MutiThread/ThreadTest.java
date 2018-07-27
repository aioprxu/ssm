package com.aiopr.MutiThread;


import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程测试
 * Created by Administrator on 2017/11/23.
 */
class Threada implements Runnable{
    volatile int x = 0;
    @Override
    public void run() {
        System.out.println("hhhh+"+(++x));
    }
}
class Test{
    Test(){
        System.out.println("Test loading.....");
    }
    static {
        System.out.println("Static T loading....");
    }
    class S{
        S (){System.out.println("Static S loading....");}
    }
}
public   class ThreadTest {

    public static void main(String[] args) {


        System.out.println(
                1^2^2//异或
        );


//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++)
//        cachedThreadPool.execute(new Threada());
//
//        cachedThreadPool.shutdown();

        int x= 2;
        Object O = new Object();
        O.equals(x);


    }


    static void moveZeros(Vector<Integer> a) {
        Vector<Integer> noZero = new Vector<Integer>();
        for (int i = 0; i < a.size(); i++)
            if (a.get(i) != 0)
                noZero.add(a.get(i));
        for (int i = 0; i < noZero.size(); i++)
            a.set(i,noZero.get(i));

        for (int i = noZero.size(); i < a.size(); i++) {
            a.set(i,0);
        }


    }

    static int removeval(int[] a,Integer val){

        int len = a.length;
        for (int i = 0 ; i< len; ++i){
            while (a[i]==val ) {
                a[i]=a[--len];
            }
        }
        return len;

    }

    static int removevalfromArray(int[] a){

        int x=0;
        int temp;
        int len = a.length;

        for (int i = 0; i < a.length; i++) {

            x = a[i];
            for (int j = i + 1; j < len; j++) {

                if (a[j] == x) {
                    temp = a[j];
                    a[j] = a[--len];
                    a[len] = temp;
                    j--;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(a[j]>a[i])
                {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        return len;

    }

    static int[] remove2(int[] A){
        int n = A.length;
        if(n < 2) return A;
        int id = 1;
        for(int i = 1; i < n; ++i)
            if(A[i] != A[i-1]) A[id++] = A[i];
        return A;
    }

    static void threeroadsort(int[] a){
        int n = a.length;
        int zero = -1;// [zero,i-1]为1
        int two = n;//[two,n)=2


        for (int i = 0; i < two; ) {
            if(a[i]==1)
                i++;
            else if(a[i]==2)
            {
               swap(a,i,--two);
//                --two;
            }
            else {
                assert (a[i]==0);
                swap(a,++zero,i++);
            }
        }

        for (
                int i = 0;
                i < a.length; i++)

        {
            System.out.println(a[i]);
        }
    }

    static void swap(int[] a ,int i , int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    static void mergesort(int[] a , int[] b){
        int[] c = new int[a.length+b.length];
        for (int i = 0; i < a.length; i++) {
            c[i]=a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[a.length+i] = b[i];
        }
    }

    static void sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                swap(a,i,j);
            }
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr1 = m -1, curr2 = n -1, start = m + n-1;
        while (curr1 >= 0 && curr2 >=0){
            if(nums1[curr1] > nums2[curr2]) nums1[start--] = nums1[curr1--];
            else nums1[start--] = nums2[curr2--];
        }
        if(curr1 <= 0) {
            while(curr2>= 0) nums1[start--] = nums2[curr2--];
        }

        for (
                int i = 0;
                i < nums1.length; i++)

        {
            System.out.println(nums1[i]);
        }
    }

}

