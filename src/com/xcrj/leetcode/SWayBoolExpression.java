package com.xcrj.leetcode;

public class SWayBoolExpression {
    static class Info{
        int t;//true方法数
        int f;
        Info(){}
        Info(int t,int f){
            this.t=t;
            this.f=f;
        }
    }
    public static int wayBool(String expression,boolean desired){
        Info ans=f(expression.toCharArray(),0,expression.length()-1);
        return desired?ans.t:ans.f;
    }

    //l~r len是奇数。l=r 只有1个元素时，一定是数字0/1
    private static Info f(char[]cs,int l,int r){
        int t=0,f=0;
        if(l==r){//递归到只有1个元素
            t+=cs[l]=='1'?1:0;
            f+=cs[l]=='0'?1:0;
        }else{
            for (int split = l+1; split < r; split+=2) {
                //split最后算
                Info left=f(cs,l,split-1);
                Info right=f(cs,split+1,r);
                switch (cs[split]){
                    case '&':
                        t+=left.t*right.t;
                        f+=left.t*right.f+ left.f*right.t+ left.f* right.f;
                        break;
                    case '^':
                        t+=left.t*right.f+ left.f*right.t;
                        f+=left.t*right.t+left.f* right.f;
                        break;
                    case '|':
                        t+=left.t*right.f+ left.f*right.t+left.t*right.t;
                        f+=left.f* right.f;
                        break;
                }
            }
        }

        return new Info(t,f);
    }

    //记忆化搜索
    public static int wayBool2(String expression,boolean desired){
        Info[][]dp=new Info[expression.length()][expression.length()];
        Info ans=f2(expression.toCharArray(),0,expression.length()-1,dp);
        return desired?ans.t:ans.f;
    }

    //l~r len是奇数。l=r 只有1个元素时，一定是数字0/1
    private static Info f2(char[]cs,int l,int r,Info[][]dp){
        if(dp[l][r]!=null){
            return dp[l][r];
        }

        int t=0,f=0;
        if(l==r){//递归到只有1个元素
            t+=cs[l]=='1'?1:0;
            f+=cs[l]=='0'?1:0;
        }else{
            for (int split = l+1; split < r; split+=2) {
                //split最后算
                Info left=f2(cs,l,split-1,dp);
                Info right=f2(cs,split+1,r,dp);
                switch (cs[split]){
                    case '&':
                        t+=left.t*right.t;
                        f+=left.t*right.f+ left.f*right.t+ left.f* right.f;
                        break;
                    case '^':
                        t+=left.t*right.f+ left.f*right.t;
                        f+=left.t*right.t+left.f* right.f;
                        break;
                    case '|':
                        t+=left.t*right.f+ left.f*right.t+left.t*right.t;
                        f+=left.f* right.f;
                        break;
                }
            }
        }

        dp[l][r]=new Info(t,f);
        return dp[l][r];
    }
}