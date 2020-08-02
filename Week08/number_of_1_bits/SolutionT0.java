package io.kvh.algo.w8.c16.number_of_1_bits;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/7/29.
 * https://leetcode-cn.com/problems/number-of-1-bits/
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
                new TestPair<>(0b00000000000000000000000000001011, null, 3, null)
                ,
                new TestPair<>(0b00000000000000000000000010000000, null, 1, null)
                ,
                new TestPair<>(0b11111111111111111111111111111101, null, 31, null)

        );

        for (TestPair<Integer, int[], Integer, Integer> p : tables) {
            Assert.assertEquals((int) p.expect, new SolutionT0().hammingWeight(p.input1));
        }
    }

    /**
     * x&=(x-1): remove the right most 1
     */
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            if ((n & 1) == 1) sum++;
            n >>>= 1;
        }
        return sum;
    }

    /**
     * x&=(x-1): remove the right most 1
     */
    public int hammingWeightV0(int n) {
        int sum = 0;
        while (n != 0) {
            n &= (n - 1);
            sum++;
        }
        return sum;
    }

}
