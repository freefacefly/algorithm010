package io.kvh.algorithm.w4.c9.number_of_islands;

import javafx.util.Pair;
import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by kvh on 2020/7/5.
 * https://leetcode-cn.com/problems/number-of-islands/
 */
class SolutionT0 {

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
        List<TestPair<char[][], int[], Integer, Integer>> tables = Arrays.asList(
                new TestPair<>(new char[][]{
                        new char[]{'1', '1', '1', '1', '0'},
                        new char[]{'1', '1', '0', '1', '0'},
                        new char[]{'1', '1', '0', '0', '0'},
                        new char[]{'0', '0', '0', '0', '0'}
                }, null, 1, null)
                ,
                new TestPair<>(new char[][]{
                        new char[]{'1', '1', '0', '0', '0'},
                        new char[]{'1', '1', '0', '0', '0'},
                        new char[]{'0', '0', '1', '0', '0'},
                        new char[]{'0', '0', '0', '1', '1'}
                }, null, 3, null)
        );

        for (TestPair<char[][], int[], Integer, Integer> p : tables) {
            Assert.assertEquals((int) p.expect, new SolutionT0().numIslands(p.input1));
        }
    }

    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null) {
            return count;
        }

        m = grid.length;
        if (m == 0) {
            return count;
        }

        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    Queue<Pair<Integer, Integer>> neighbors = new LinkedList<>();
                    neighbors.offer(new Pair<>(i, j));

                    while (!neighbors.isEmpty()) {
                        Pair<Integer, Integer> pair = neighbors.poll();
                        int ni = pair.getKey();
                        int nj = pair.getValue();

                        int left = ni - 1, right = ni + 1, up = nj - 1, down = nj + 1;

                        if (left >= 0 && grid[left][nj] == '1') {
                            neighbors.add(new Pair<>(left, nj));
                            grid[left][nj] = '0';
                        }

                        if (right < m && grid[right][nj] == '1') {
                            neighbors.add(new Pair<>(right, nj));
                            grid[right][nj] = '0';
                        }

                        if (up >= 0 && grid[ni][up] == '1') {
                            neighbors.add(new Pair<>(ni, up));
                            grid[ni][up] = '0';
                        }

                        if (down < n && grid[ni][down] == '1') {
                            neighbors.add(new Pair<>(ni, down));
                            grid[ni][down] = '0';
                        }
                    }
                }
            }
        }


        return count;
    }

    public int numIslandsV0(char[][] grid) {
        int count = 0;
        if (grid == null) {
            return count;
        }

        m = grid.length;
        if (m == 0) {
            return count;
        }

        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfsMark(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfsMark(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';
        //[0][x][0]
        //[x][1][x]
        //[0][x][0]
        //check for direction
        dfsMark(grid, i - 1, j);
        dfsMark(grid, i + 1, j);
        dfsMark(grid, i, j + 1);
        dfsMark(grid, i, j - 1);
    }

}
