package io.kvh.algo.w8.c16.n_queens_ii;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/7/31.
 * https://leetcode-cn.com/problems/n-queens-ii/
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
        List<TestPair<Integer, int[], Integer, Integer>> tables = Arrays.asList(
                new TestPair<>(4, null, 2, null)
        );

        for (TestPair<Integer, int[], Integer, Integer> p : tables) {
            Assert.assertEquals((int) p.expect, new SolutionT0().totalNQueens(p.input1));
        }
    }

    private int count;

    public int totalNQueens(int n) {
        dfs(0, 0, 0, 0, n);
        return count;
    }

    private void dfs(int row, int col, int pie, int na, int n) {
        if (row >= n) {
            count++;
            return;
        }

        int bits = (~(col | pie | na)) & ((1 << n) - 1);

        while (bits != 0) {
            //lowbit
            int p = bits & (-bits);
            bits &= (bits - 1);

            dfs(row + 1, col | p, (pie | p) << 1, (na | p) >> 1, n);
        }
    }


}
