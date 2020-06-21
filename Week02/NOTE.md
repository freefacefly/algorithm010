# 学习感悟

* 掌握基础数据结构，让其成为解题思路

例如 map 的思想，可以使用一个定长数组 table 来模拟 map 的运行。

也可以使用一些语言的内置结构来辅助解决问题



# HashMap

hashmap，有两个参数：capacity 和 load factor

前者是多少个 bucket，后者是bucket 扩容的条件阈值

maxSize = capacity * loadFactor

注释中，所谓的 binned hash table，bin 是指箱子的意思，aka bucket。

* hash方法

所谓的将高位的 bit，spreads 到低位。

本质：因为槽位是比较少的，为了使得分布尽量的均匀；把原始 hashcode 的高16 位，扩散到低 16 位；降低哈希冲突的概率。

**混合原始哈希码的高位和低位，以此来加大低位的随机性**。

映射桶的时候，做了如下操作：

```
(n-1) & hash //类似于对 n 取模
```

* 其他关键点

  树化