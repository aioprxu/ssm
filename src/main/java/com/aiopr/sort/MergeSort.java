package com.aiopr.sort;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/30.
 */
public class MergeSort {
    void mergesort(int a[], int first, int last, int temp[])
    {
        if (first < last)
        {
            int mid = (first + last) / 2;
            mergesort(a, first, mid, temp);    //左边有序
            mergesort(a, mid + 1, last, temp); //右边有序
            merge(a, first, mid, last, temp); //再将二个有序数列合并
        }
    }
    public void merge(int[] a,int first,int mid,int last,int temp[]){
        int i=first,j=mid,k=0,m=mid,n=last;
        int[] c =new int[m+n];
        while (i<m&&j<n) {
            if (a[i] < a[j]) {
                c[k] = a[i];
                i++;
                k++;
            }
            if (a[i] > a[j]) {
                c[k] = a[j];
                j++;
                k++;
            }
        }

        while (i < m)
                c[k++] = a[i++];
        while (j < n)
                c[k++] = a[j++];

        for (i = 0; i < k; i++) {
            a[first+i] = c[i];
        }
    }
}
