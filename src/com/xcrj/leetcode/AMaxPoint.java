package com.xcrj.leetcode;

/**
 * 窗口
 * O(n)
 */
public class AMaxPoint {
    public static int maxPoint(int[]as,int len){
        int l=0,r=0,n=as.length,max=0;
        while(l<n){
            //不满足才会退出 所以 不用 r-l+1
            while(r<n&&as[r]-as[l]<=len){
                r++;
            }
            max=Math.max(max,r-(l++));//l++
        }
        return max;
    }
}
