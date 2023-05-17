package com.xcrj.ordered_table;
/**
 * 跳表
 * 利用了高度跳过了大量无关结点，与数据的输入情况无关
 * 操作
 * - 默认结点（值最小），概率p 层数
 * - 新入结点，概率p 层数，从左往右 从上往下 1.扩充层数 2.找<=的结点，
 * -- <=：就跳过去。从左往右 从上往下 1.扩充层数 2.找<=的结点，
 * -- >：则判断层数更矮>>则开始连接
 */
public class SkipTable {
    public static void main(String[] args) {
        
    }
}
