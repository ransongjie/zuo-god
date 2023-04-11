package com.xcrj.force;

import java.util.Stack;

//逆序栈，只能使用递归函数
public class DescStack {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(3);stack.push(2);stack.push(1);
        // int bottom=reverse(stack);
        for (int i = 0; i < stack.size(); i++) {
        // while(!stack.isEmpty()){
            int bottom=stack.pop();
            stack.push(bottom);
        }
        System.out.println(stack);
    }

    public static int reverse(Stack<Integer> stack) {
        int r=stack.pop();
        if(!stack.isEmpty()) return r;
        int last=reverse(stack);
        stack.push(r);
        return last;
    }
}
