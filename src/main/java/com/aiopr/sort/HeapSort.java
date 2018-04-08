package com.aiopr.sort;

/**
 * Created by Administrator on 2018/3/25.
 */
public class HeapSort {

    public static void main(String[] args) {
        int a [] = {2,3,45,6,7,2,3,4,5,8,2,43,4,6};
        sort(a);
        for(int i:a){
            System.out.println(i);
        }
    }


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
