package com.xcrj.bit;

//数组中只有1个元素奇数次 其它偶数次
//{2, 2, 3, 3, 1, 4, 4}
public class Yihuo1Odd {
    public static void main(String[] args) {
        int[] as={2, 2, 3, 3, 1, 4, 4};
        int num=0;
        int n=as.length;
        for(int i=0;i<n;i++){
            num^=as[i];
        }
        System.out.println(num);
    }


}
