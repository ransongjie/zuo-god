# pass
|Package|Description|
|---|---|
|bit|位操作|
|sort|排序|
|dichotomy|二分法|
|link|链表|
|tree|二叉树|
|graph|图|
|prefix_tree|前缀树|
|greed|贪心|
|force|暴力递归|
|hash|hash|
|union_set|并查集|
|str|字符串，KMP，Manacher|
|window_max|窗口最大值|
|mono_stack|单调栈|
|limit_resource|资源限制|
|dp|暴力递归改动态规划|
|ordered_table|有序表|

|Class|Description|Introduction|
|---|---|---|
|bit/Yihuo|swap||
|bit/Yihuo1Odd|数组中只有1个元素奇数次其它偶数次||
|bit/Yihuo2Odd|数组中只有2个元素奇数次且两个元素不等其它偶数次||
|bit2/AddSubMulDiv|加减乘除||
|bit2/LargeNum|返回更大的值||
|bit2/Power24|2的幂4的幂||
|sort/SelectSort|选择排序||
|sort/QuickSort|冒泡排序||
|sort/InsertSort|插入排序||
|sort/QuickSort1|选择end做轴值，leftBorder变量保存左边界，<=end放到左边界||
|sort/QuickSort2|选择e做轴值，lb内的元素`<e`，rb内的元素`>e`，lb到rb之间的元素等于e||
|sort/QuickSort3|选择随机值做轴值，lb内的元素`<e`，rb内的元素`>e`，lb到rb之间的元素等于e||
|sort/MergeSort|归并排序||
|sort/MergeLSum|小和，左侧比我小的数的和等价于右侧比我大数的个数||
|sort/MergeReversePair|逆序对个数，右侧比我小的数的个数||
|sort/HeapSort|heapInsert, heapfy||
|sort/HeapSort2|heapfy||
|sort/BucketSort|桶排序||
|sort/RadixSort|基数排序||
|dichotomy/Dichotomy|经典二分查找||
|dichotomy/GeKLeftmost|>=k最左边的数||
|dichotomy/LocalMin|局部最小值||
|link/CPRandomP|深度拷贝含有随机指针的链表||
|link/Circle|链表环的入口结点||
|link/CrossPoint|返回可能有环链表的1个交点，可能没有交点||
|link/L2Public|两独立有序链表的公共部分||
|link/PalindromeL|回文链表||
|tree/PreOrder|前序遍历，非递归||
|tree/Inorder|中序遍历，非递归||
|tree/PostOrder|后序遍历，非递归||
|tree/WidthOrder|宽度优先||
|tree/PreOrderSerialize PreOrderDeserialize|前序遍历序列化，反序列化||
|tree/InOrderSuccessor|中序遍历后继结点||
|tree/LowestCommonAncestor|最低公共祖先||
|tree/MaxWidth|最大宽度||
|tree/PaperFolding|折纸，从上到下输出折痕方向||
|tree/ABinarySearchTree|是否二叉搜索树||
|tree/IsAVLTree|是否平衡二叉树||
|tree/CompleteBinaryTree|是否完全二叉树||
|tree/FullBinaryTree|是否满二叉树||
|graph/Convert|转换||
|graph/TraDeepFirst|深度优先||
|graph/TraWidthFirst|宽度优先||
|graph/MSTKruskal|最小生成树，简单并查集||
|graph/MSTKruskal2|最小生成树，并查集||
|graph/MSTPrim|最小生成树||
|graph/SPDijkstra|最短路径||
|graph/SPDijkstra2|最短路径，改进自定义堆||
|graph/TopoSort|拓扑排序||
|str/KMP|字符串匹配|无法全部匹配选择部分匹配|
|str/Manacher|最长回文子串|利用历史最大回文信息|
|hash|hash||
|force|暴力递归||
|dp|暴力递归改动态规划||
|union_set/Island|小岛数量||
|union_set/UnionFind (并查集)|两结点是否在同一个集合，合并两个结点|
|prefix_tree/PrefixTree (前缀树)|前缀树，单词树|
|segment_tree/SegmentTree (线段树)||
|binary_idx_tree/BinaryIdxTree (树状数组，二叉索引树)|O(logn)区间和，前缀和|
|window_max/DynamicWindowMax (双端队列)|动态窗口内的最大值|双端队列|
|mono_stack/MonotonicStack (单调栈)|左右最近且大的值|出栈后，栈顶左近且大，待入栈右近且大|
|mono_stack/CumMin (单调栈)|左右最近且小的值|出栈后，栈顶左近且小，待入栈右近且小|
|ordered_table/BST|二叉搜索树|中序遍历递增|
|ordered_table/BST2|二叉搜索树|搜索树|
|ordered_table/AVL|平衡二叉搜索树|搜索树|
|ordered_table/SBTree|Size-Balance Tree|搜索树|
|ordered_table/RBTree|红黑树|搜索树|
|ordered_table/SkipTable|跳表|搜索树|
|b_tree/BTree|B树|索引树|
|b_tree/BPlusTree|B+树|索引树，范围搜索|
# 计算机bit
```
 * 计算机中负数使用补码表示
 * 1=0000 0001
 * 0=0000 0000
 * -1
 * 原码=1000 0001
 * 补码=1111 1111
 * -2
 * 原码=1000 0010
 * 补码=1111 1110
 * -128
 * 补码=1000 0000
```
# 位运算
- 相反数 `~x+1`
- 最优侧的1 `x&(~x+1)`
# sort
|Type|Profile|
|---|---|
|QuickSort|O(nlogn), recursive O(logn), unstable|
|MergeSort||
|HeapSort||
|RadixSort||
|InsertSort||
|BubbleSort||
|SelectSort||
# 注意
- 代码思想来自左神课程，代码编写由自己完成

# tree套路
- 上下两层，整棵树
- 整棵树：当前结点，左子树，右子树
- 每一个结点都会到达3次
- 遍历次序
- 左子树返回值, 右边子树返回值, 本层返回值

# 有序表
## B+树
![](./img/BPlusTree.png)

# 参考
- [总结自左程云 bilibili课程代码](https://www.bilibili.com/video/BV13g41157hK)
