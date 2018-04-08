package com.aiopr.Heap;

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;

/**
 * Created by Administrator on 2018/4/8.
 */
public class MaxHeap {
    public static void swap(int [] array,int a,int b){
        array[a]=array[a]^array[b];
        array[b]=array[a]^array[b];
        array[a]=array[a]^array[b];
    }
    public static void sort(int [] array){
        for(int i = array.length/2-1;i>=0;i--){
            adjustHeap(array,i,array.length);
        }
        for(int i = array.length-1;i>0;i--){
            swap(array,i,0);
            adjustHeap(array,0,i);
        }
    }

    private static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for(int k=i*2+1;k<length;k++){
            if(k+1<length&&array[k]<array[k+1])
                k=k+1;
            if(array[k]>temp){
                array[i]=array[k];
                i=k;
            }else {
                break;
            }
        }
        array[i]=temp;
    }
}
