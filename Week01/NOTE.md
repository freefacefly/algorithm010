# 关于学习方法

在学习了[如何高效学习算法训练营课程](https://u.geekbang.org/lesson/19?article=240408)这一章节之后。我觉得接受了反常识的观念，但是很值得一试！

五毒神掌，记住了。

# 数组、链表、跳表

## ArrayList

实现结构是连续的空间。

时间复杂度：

```
prepend O(1)
append O(1)
lookup O(1)
insert O(n)
delete O(n) 
```

## LinkedList

时间复杂度：

```
prepend O(1)
append O(1)
lookup O(n)
insert O(1)
delete O(1)
```

## Skip List

对于`有序`的链表的优化。使用空间换时间策略。

> 一维数组加速，变成二维

添加多级查找索引，以快速定位元素所谓的位置。

时间复杂度：O(log(n))

空间复杂度：O(n)

> 思想在 LRU-Cache 和 Redis 中有应用。

# 栈和队列

## Stack 和 Queue 的关键点

Stack：（FILO）先入后出；添加、删除都是 O(1)

Queue：（FIFO）先入先出；添加、删除都是 O(1)



Deque：双端队列



priority queue：优先级队列