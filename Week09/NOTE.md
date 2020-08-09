# unique-paths-ii

```
dp[i][j]：从左上角到达(i,j)的路径数量

if  (obstacleGrid[i][j] == 1) dp[i][j] = 0
else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
```

## DP Vs. Recursive&DivideConquer

## 关键点：

动态规划和递归、分治没有根本区别

共性：重复子问题

差异性：最优子结构、中途可以淘汰次优解

## 高级dp

复杂度的来源：

1）状态拥有更多维度，（二维，三维，甚至更多，还需要压缩）

2）状态转移方程更难

本质：

内功、逻辑思维、数学

