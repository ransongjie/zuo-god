package com.xcrj.leetcode;

/**
 * 绳子最多压中几个点
 * 窗口
 * O(n)
 */
public class A000MaxPoint {
    /**
     * @param as 值是x轴上的点
     * @param len 绳子长度
     * @return
     */
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
