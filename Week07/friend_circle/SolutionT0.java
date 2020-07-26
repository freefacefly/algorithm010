package io.kvh.algo.w7.c13.friend_circle;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/7/23.
 * https://leetcode-cn.com/problems/friend-circles
 */
public class SolutionT0 {

    public static class TestPair<T_Input_1, T_Input_2, T_Expect, T_Target> {
        final private T_Input_1 input1;
        final private T_Input_2 input2;
        final private T_Expect expect;
        final private T_Target target;

        public TestPair(T_Input_1 input1, T_Input_2 input2, T_Expect expect, T_Target target) {
            this.input1 = input1;
            this.input2 = input2;
            this.expect = expect;
            this.target = target;
        }
    }

    public static void main(String[] args) {
        List<TestPair<int[][], int[], Integer, Integer>> tables = Arrays.asList(
                new TestPair<>(new int[][]{
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}}, null, 2, null)
                ,
                new TestPair<>(new int[][]{
                        {1, 1, 0},
                        {1, 1, 1},
                        {0, 1, 1}}, null, 1, null)
        );

        for (TestPair<int[][], int[], Integer, Integer> p : tables) {
            Assert.assertEquals((int) p.expect, new SolutionT0().findCircleNum(p.input1));
        }
    }

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int m = M.length;

        UnionFind uf = new UnionFind(m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }


    static class UnionFind {
        private int count;
        private final int[] parent;
        //make balance union
        private final int[] size;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 0;
            }
        }

        public int find(int p) {
            //until the root
            while (p != parent[p]) {
                //compress route
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            //make the tree balance
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int count() {
            return count;
        }
    }

    public int findCircleNumV0(int[][] M) {
        if (M == null || M.length == 0) return 0;

        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 0;
                //solve the next row recursively
                dfs(M, visited, j);
            }
        }
    }

}
