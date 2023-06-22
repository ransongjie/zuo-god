package com.xcrj.leetcode;

public class N1QuickPow {
    //a^b
    public static int quickPow(int a,int b){
        int t=a;
        int ans=1;
        while(b!=0){
            if((b&1)!=0){
                ans*=t;
            }
            t*=t;
            b>>=1;
        }

        return ans;
    }

    public static void main(String[] args) {
        quickPow(2,4);
        System.out.println(quickPow(2,4));
    }
}
