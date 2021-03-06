# 并查集

又叫disjoinset

## 用途：

解决组团和配对问题

是否是好友，是否是组

## 步骤

1）初始化

2）union

3）find

# Trie树

## 特性

1. 前缀树，存储的不存完整单词，而是字符
2. 根节点到叶节点的路径，是一个单词
3. 所有路径代表的单词都不一样

## 核心思想

1. 空间换时间
2. 用字符串的公共前缀来降低查询时间的开销达到提高效率的目的

# AVL树和红黑树

## 目的

为了维护相对平衡的树状结构

## AVL 树

引入了平衡因子，左右子树的高度差。 「-1，0，1」

### 维护方式

右右子树——左旋

左左子树——右旋

左右子树——左右旋

右左子树——右左旋



> 旋转的时候，新根节点，如果原来有子树，需要挂到原根节点下。



## 红黑树

保证任何一个节点的左右子树高度差小于 2 倍。

与 AVL 树的对比：

1）AVL 提供更快的查找，因为更加严格的平衡

2）红黑树提供更快的插入和删除，因为维护代价相对较低

3）AVL 存储了平衡因子或者高度，带来更大的存储开销，红黑树只需要一个 bit 的开销

4）红黑树通常用于语言标准库，AVL 数通常用于数据库



