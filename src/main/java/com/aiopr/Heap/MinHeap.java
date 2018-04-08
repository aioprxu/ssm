package com.aiopr.Heap;

/**
 * Created by Administrator on 2018/4/8.
 */
public class MinHeap {
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

    public static void sort(int arr[]){
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        for(int i = arr.length-1;i>0;i--){
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
    }
    public static void adjustHeap(int arr[],int i,int length){
        int temp = arr[i];
        for(int k = i*2+1;k<length;k++){
            if(k+1<length&&arr[k]>arr[k+1]){
                k=k+1;
            }
            if(arr[k]<temp){
                arr[i]=arr[k];
                i=k;
            }
            else break;
        }
        arr[i]=temp;
    }

}
