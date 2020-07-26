package io.kvh.algo.w1.c3.climbing_stairs;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/7/21.
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class SolutionT2 {
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
                new TestPair<>(2, null, 2, null)
                ,
                new TestPair<>(3, null, 3, null)
        );

        for (TestPair<Integer, int[], Integer, Integer> p : tables) {
            Assert.assertEquals((int) p.expect, new SolutionT2().climbStairs(p.input1));
        }
    }

    /**
     * dp[i]：different ways to clim n stairs
     * dp[i] = dp[i-1]+dp[i-2]
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) return n;

        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = curr;
            curr += prev;
            prev = tmp;
        }

        return curr;
    }


}
