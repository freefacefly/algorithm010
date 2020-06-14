学习笔记

# Queue 源码分析

Queue 提供了一种 FIFO（先进先出）的数据结构，也就是队列。

Java 中的 Queue 是一个接口，主要是通过两组 API，这两组API 是只是对于异常情况的处理不一样。

| 抛出异常  | 返回特殊值 | 描述                   |
| --------- | ---------- | ---------------------- |
| add(e)    | offer(e)   | 在队列尾部添加一个元素 |
| remove()  | poll()     | 从队列头部移除一个元素 |
| element() | peak()     | 检查最后一个元素       |

# PriorityQueue 源码分析

PriorityQueue 提供一种优先队列数据结构。

在 Java 的实现中，队列的头部所谓最小的元素，元素的顺序，是由自然顺序或者由 comparator 定义的。

由于 PriorityQueue 的父类 AbstractQueue 实现了 Queue 接口，所以它是具有 Queue 接口的所有的方法。

该数据结构，入队和出队的时间复杂度是 O(log(n))，remove(e)和 contain(e) 时间复杂度是O(n)。

下列的数据结构和方法，帮助实现排序：

## Object[] queue

作为 balanced binary heap 的底层数据结构

## siftUp(int k, E x)

将 item x 放到 k 位置。在树上上移元素 x，直到大于等于parent或者 root。

## siftDown(int k, E x)

将 item x 放到 k 位置。在树上下移元素 x，直到小于或者等于 child或者自己就是叶节点。