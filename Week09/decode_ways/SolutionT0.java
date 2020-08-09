package io.kvh.algo.w6.decode_ways;

import com.sun.org.apache.bcel.internal.generic.FSUB;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/7/19.
 * https://leetcode-cn.com/problems/decode-ways/
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
        List<TestPair<String, int[], Integer, Integer>> tables = Arrays.asList(
                new TestPair<>("12", null, 2, null)
                ,
                new TestPair<>("226", null, 3, null)
                ,
                new TestPair<>("27", null, 1, null)
        );

        for (TestPair<String, int[], Integer, Integer> p : tables) {
            Assert.assertEquals((int) p.expect, new SolutionT0().numDecodings(p.input1));
        }
    }

    private int decode(String str) {
        int num = Integer.parseInt(str);
        if (num < 1) return 0;
        if (10 <= num && num <= 26) return 2;
        return 1;
    }

    public int numDecodings(String s) {
        if (s == null) return 0;
        int len = s.length();
        if (len == 0) return 0;
        //can't decode string with leading zero
        if (s.charAt(0) == '0') return 0;

        char[] chars = s.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < len; i++) {
            if (chars[i] == '0') {
                //wont' produce new decode ways
                if (chars[i - 1] == '1' || chars[i - 1] == '2') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else {
                //split into two ways
                if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) {
                    dp[i + 1] = dp[i - 1] + dp[i];
                } else {
                    //other case
                    dp[i + 1] = dp[i];
                }
            }
        }

        return dp[len];
    }
}
