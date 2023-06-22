package com.xcrj.leetcode;

public class S1Factorial0Num {
    public static int factorial0Num(int n){
        int ans=0;
        while(n!=0){
            n/=5;
            ans+=n;
        }
        return ans;
    }
}
