package io.kvh.algo.w8.c16.power_of_two;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/7/30.
 * https://leetcode-cn.com/problems/power-of-two/
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
        List<TestPair<Integer, int[], Boolean, Integer>> tables = Arrays.asList(
                new TestPair<>(1, null, true, null)
                ,
                new TestPair<>(16, null, true, null)
                ,
                new TestPair<>(218, null, false, null)
        );

        for (TestPair<Integer, int[], Boolean, Integer> p : tables) {
            Assert.assertEquals(p.expect, new SolutionT0().isPowerOfTwo(p.input1));
        }
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        long x = (long) n;
        //x&(x-1) -> remove lowbit, should be zero
        return (x & (x - 1)) == 0;
    }

    public boolean isPowerOfTwoV0(int n) {
        if (n <= 0) return false;
        long x = (long) n;
        //x&-x -> lowbit, only one 1
        return (x & (-x)) == x;
    }

    public boolean isPowerOfTwoV1(int n) {
        if (n <= 0) return false;
        while ((n & 1) == 0) n >>= 1;
        return n == 1;
    }
}
