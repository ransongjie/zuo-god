package com.xcrj.pass2.limit_resource;
/**
 * 40亿个无符号整数，中位数
 * 
 * ref: https://blog.csdn.net/A657997301/article/details/110187446
 * 桶数值分片统计：在10MB内存下，将42亿的大数值区间划分成250万个小数值区间(桶数量)，每个小区间大小为1680(桶区间)
 * 
 * 桶项类型：桶项用于统计出现次数，40亿个数都是同一个数，uint
 * 桶数量：可用内存/桶项占用内存（4B）
 * 桶区间：uint能表示的数个数，2^32/桶数量
 * 
 * 分片
 * - 分片0, 数值范围[0*Y,1*Y-1], 桶0
 * - 分片1, 数值范围[1*Y,2*Y-1], 桶1
 * - ...
 * - 分片i, 数值范围[i*Y,(i+1)*Y-1], 桶i
 * 
 * 步骤
 * 1. 在内存不够用的情况下，先模糊统计中位数所在区间
 * 2. 偏移量为1，内存不够，goto 1
 * 3. 偏移量为1，内存足够，直接定位
 * 
 * 极限 8B：
 * - 在8B的内存下，将2^32的大数值区间划分成2个小数值区间(桶数量)，每个区间大小为2^32/2 约21亿(桶区间)
 * - 退化为二分查找
 * 
 * 极限 内存足够：1个桶1个数，桶排序变为计数排序，直接1次定位到中位数
 */
public class Median {
    
}
