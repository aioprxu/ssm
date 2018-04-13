package com.aiopr;

import com.sun.org.apache.bcel.internal.util.ClassSet;
import com.sun.xml.internal.ws.message.source.PayloadSourceMessage;

import java.util.*;

/**
 * 笔试题
 */
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


class Mainn {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long arr[] = new long[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextLong();
        }
        for(int i=0;i<n;i++){
            int x=1;
            long res = arr[i];
            if(res%2!=0)
                System.out.println("No");
            else {
                for(int k=2;k<res/2;k=k+2){
                    if(res%k==0&&(res/k)%2==1) {
                        System.out.println(res / k + " " + k);
                        break;
                    }
                }
            }
        }
    }
}

class tes{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t--!=0){
            String str = in.next();
            char ch[] = str.toCharArray();
            int numl=0,numr=0;
            for(int i = 0;i<str.length();i++){
                if(ch[i]=='(')
                    numr++;
                else numl++;
            }
            if(numl!=numr){
                System.out.println("No");
                continue;
            }
            Stack<Character> s = new Stack<>();
            int cnt=0;
            for(int i = 0;i<str.length();i++){
                if(ch[i]=='(')
                    s.push(ch[i]);
                else {
                    if(s.empty())
                        continue;
                    char b = s.peek();
                    if(b=='('&&ch[i]==')'){
                        s.pop();
                        cnt++;
                    }
                }
            }
            if(cnt==str.length()/2){
                if(cnt>=str.length()/2-2)
                    System.out.println("Yes");
                else System.out.println("No");
            }
        }

    }
}


class hhh{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        char [] ch1 = str1.toCharArray();
        String str2 = new StringBuffer(str1).reverse().toString();
        char [] ch2 = str2.toCharArray();
        int [][]dp = new int [1000][1000];
        System.out.println(LCS(ch1,ch2,dp)+2);
    }
    public static int LCS(char [] a,char[] b ,int [][] c){
        c = new int[a.length][];
        //初始化c[i][0]
        boolean contain = false;
        for (int i = 0; i < a.length; i++)
        {
            c[i] = new int[b.length];
            if (a[i] == b[0] || contain)
            {
                c[i][0] = 1;  contain = true;
            }
            else
            {
                c[i][0] = 0;
            }
        }
        //初始化c[0][j]
        contain = false;
        for (int j = 0; j < b.length; j++)
        {
            if (b[j] == a[0])
            {
                c[0][j] = 1;  contain = true;
            }
            else
            {
                c[0][j] = 0;
            }
        }

        //递归求得LCS的长度：c[i][j]
        for (int i = 1; i < a.length; i++)
        {
            for (int j = 1; j < b.length; j++)
            {
                if (a[i] == b[j])
                {
                    c[i][j] = c[i - 1][j - 1] + 1;  // 相等,pre+1
                }
                else if (c[i - 1][j] >= c[i][j - 1])   // get max of pre string
                {
                    c[i][j] = c[i - 1][j];
                }
                else
                {
                    c[i][j] = c[i][j - 1];
                }
            }
        }
        return c[a.length-1][b.length-1];
    }
}

class tt{
    public static tt getclass(){
        return new tt();
    }

    public static void main(String[] args) {
        System.out.println(getclass());
        System.out.println(tt.class);
        System.out.println();
    }
}

