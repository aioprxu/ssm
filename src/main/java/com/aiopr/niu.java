package com.aiopr;

import java.util.Scanner;
import java.util.Arrays;
public class niu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int a[] = new int [n];
        for(int i = 0;i<n;i++){
            a[i]= in.nextInt();
        }
        Arrays.sort(a);
        int j =0;
        while(j<n){
            int sum=0;
            int i =j;
            while(sum<s){
                sum+=a[i];
                i++;
            }
            if(sum-a[j]<s){
                System.out.println(i-j);
                return;
            }
            else j++;
        }
    }
}