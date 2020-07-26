package io.kvh.algo.w7.c13.surrounded_regions;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/7/23.
 * https://leetcode-cn.com/problems/surrounded-regions/
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
        List<TestPair<char[][], int[], char[][], Integer>> tables = Arrays.asList(
                new TestPair<>(new char[][]{
                        {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}
                }, null, null, null)
        );

        for (TestPair<char[][], int[], char[][], Integer> p : tables) {
            for (char[] row : p.input1) {
                System.out.println(Arrays.toString(row));
            }
            new SolutionT0().solve(p.input1);
            for (char[] row : p.input1) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null) return;
        int m = board.length;
        if (m == 0) return;

        int n = board[0].length;

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int dummy = m * n;
        UnionFind uf = new UnionFind(dummy + 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int base = i * n + j;

                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        uf.union(base, dummy);
                    } else {
                        for (int k = 0; k < 4; k++) {
                            int ix = i + dx[k];
                            int jy = j + dy[k];

                            if (board[ix][jy] == 'O') {
                                uf.union(base, ix * n + jy);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(uf.count);

        int dummyUf = uf.find(dummy);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int base = i * n + j;
                if (dummyUf == uf.find(base)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
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
}
