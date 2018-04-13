package com.aiopr;

import java.util.Scanner;

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
        return;
    }
}


class Main {
    public static void main(String[] args) {
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
        return;
    }
}