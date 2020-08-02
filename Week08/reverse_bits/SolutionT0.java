package io.kvh.algo.w8.c16.reverse_bits;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/7/30.
 * https://leetcode-cn.com/problems/reverse-bits/
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
                new TestPair<>(0b00000010100101000001111010011100, null, 0b00111001011110000010100101000000, null)
                , new TestPair<>(0b11111111111111111111111111111101, null, 0b10111111111111111111111111111111, null)
        );

        for (TestPair<Integer, int[], Integer, Integer> p : tables) {
            Assert.assertEquals((int) p.expect, new SolutionT0().reverseBits(p.input1));
        }
    }

    // process bit by bit
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) + (n & 1);
            n >>= 1;
        }
        return ans;
    }

    // you need treat n as an unsigned value
    public int reverseBitsV0(int n) {
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            if ((n >> i & 1) == 1) {
                ans |= (1 << (31 - i));
            } else {
                ans &= ~(1 << (31 - i));
            }
        }
        return ans;
    }
}
