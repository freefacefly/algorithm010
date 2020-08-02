package io.kvh.algo.w8.c16.counting_bits;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/7/31.
 * https://leetcode-cn.com/problems/counting-bits/
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
        List<TestPair<Integer, int[], int[], Integer>> tables = Arrays.asList(
                new TestPair<>(2, null, new int[]{0, 1, 1}, null)
                ,
                new TestPair<>(5, null, new int[]{0, 1, 1, 2, 1, 2}, null)
        );

        for (TestPair<Integer, int[], int[], Integer> p : tables) {
            Assert.assertEquals(Arrays.toString(p.expect), Arrays.toString(new SolutionT0().countBits(p.input1)));
        }
    }

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            //i&(i-1): remove right-most 1
            dp[i] = dp[i & (i - 1)] + 1;
        }

        return dp;
    }
}
