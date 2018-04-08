package com.aiopr.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 */
class ArrayGenerator {
    public static int[] random_order_array(int len) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] array = new int[len];
        for (int i = 0; i < len; i++)
            array[i] = list.get(i);
        return array;
    }

    public static int[] ordered_array(int len) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++)
            array[i] = i;
        return array;
    }

    public static boolean is_ordered_array(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i])
                return false;
        }
        return true;
    }

    public static void print_array(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
    public class QuickSort {
    public static void main(String[] args) {

        int[] a = ArrayGenerator.random_order_array(1000000);
        long begin = System.currentTimeMillis();
        Arrays.sort(a);
        long mid = System.currentTimeMillis();
        long x = mid - begin;
        System.out.println(ArrayGenerator.is_ordered_array(a));
        int[] b = ArrayGenerator.random_order_array(1000000);
        long start = System.currentTimeMillis();
        quick_sort(b,0,999999);
        long end = System.currentTimeMillis();
        long y = end - start;
        System.out.println(ArrayGenerator.is_ordered_array(b));

        System.out.println(y-x);
    }

    public static void quick_sort(int[] s,int l,int r){
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }
    //三数取中快排
    public static void quickSort(int[] arr, int left, int right) {
            if (left < right) {
                //获取枢纽值，并将其放在当前待处理序列末尾
                dealPivot(arr, left, right);
                //枢纽值被放在序列末尾
                int pivot = right - 1;
                //左指针
                int i = left;
                //右指针
                int j = right - 1;
                while (true) {
                    while (arr[++i] < arr[pivot]) {
                    }
                    while (j > left && arr[--j] > arr[pivot]) {
                    }
                    if (i < j) {
                        swap(arr, i, j);
                    } else {
                        break;
                    }
                }
                if (i < right) {
                    swap(arr, i, right - 1);
                }
                quickSort(arr, left, i - 1);
                quickSort(arr, i + 1, right);
            }

        }

        /**
         * 处理枢纽值
         *
         * @param arr
         * @param left
         * @param right
         */
        public static void dealPivot(int[] arr, int left, int right) {
            int mid = (left + right) / 2;
            if (arr[left] > arr[mid]) {
                swap(arr, left, mid);
            }
            if (arr[left] > arr[right]) {
                swap(arr, left, right);
            }
            if (arr[right] < arr[mid]) {
                swap(arr, right, mid);
            }
            swap(arr, right - 1, mid);
        }

        /**
         * 交换元素通用处理
         *
         * @param arr
         * @param a
         * @param b
         */
        private static void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }