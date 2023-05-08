package com.xcrj.pass2.limit_resource;
/**
 * 10G文件，存储有符号整数。5G内存。有序化
 * 
 * 方法1：小根堆数值分片操作，将 数据类型数字个数(2^32) 分成 2^5个区间 使用小根堆处理每个区间(2^27)内的数
 * 注意：堆数值分片操作
 * - 小根堆一项的大小=数据类型(4B)+1个数最多出现次数(4B)+额外空间(8B)=16B
 * - 小根堆大小=可用内存(5G)/小根堆一项的大小(16B)=向上取整=2^27
 * - 分片数量=数据类型数字个数(2^32)/小根堆大小(2^27)=2^5
 * 步骤：
 * 1. 数值分片0: -2^31+2^27*0 ~ -2^31+2^27*1-1。小根堆(2^27)操作
 * 2. 数值分片1: -2^31+2^27*1 ~ -2^31+2^27*2-1。小根堆(2^27)操作
 * 3. 数值分片2: -2^31+2^27*2 ~ -2^31+2^27*3-1。小根堆(2^27)操作
 * 4. 数值分片3: -2^31+2^27*3 ~ -2^31+2^27*4-1。小根堆(2^27)操作
 * 5. 数值分片4: -2^31+2^27*4 ~ -2^31+2^27*5-1。小根堆(2^27)操作
 * 
 * 方法2：大根堆范围统计
 * - M 数据类型最小值。X遍历完大根堆堆顶元素
 * - 将大于M小于X的数加入大根堆中，遍历完记录堆顶元素A=X
 * - 将大于A小于X的数加入大根堆中，遍历完记录堆顶元素B=X
 * - 将大于B小于X的数加入大根堆中，遍历完记录堆顶元素C=X
 * 
 * 步骤
 * 1. 大根堆不满则直接放入堆中
 * 2. 遍历数值大于堆顶，不入堆
 * 3. 遍历数值小于堆顶，pop堆顶元素，入堆
 * 4. 遍历数值等于堆顶，增加词频
 * 5. 遍历完，记录堆顶元素X。排序堆中元素，放入文件中
 * 6. 下次遍历，忽略<=X的所有元素，统计>X的元素
 */
public class DataSort {
    
}
