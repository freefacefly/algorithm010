package io.kvh.algo.w9.c20.string_to_integer_atoi;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kvh on 2020/8/4.
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
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
                new TestPair<>("42", null, 42, null)
                ,
                new TestPair<>("   -42", null, -42, null)
                ,
                new TestPair<>("4193 with words", null, 4193, null)
                ,
                new TestPair<>("words and 987", null, 0, null)
                ,
                new TestPair<>("-91283472332", null, -2147483648, null)
                ,
                new TestPair<>(" ", null, 0, null)
        );

        for (TestPair<String, int[], Integer, Integer> p : tables) {
            Assert.assertEquals((int) p.expect, new SolutionT0().myAtoi(p.input1));
        }
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int index = 0, sign = 1, total = 0;
        while (index < str.length() && str.charAt(index) == ' ') index++;

        if (index >= str.length()) return 0;

        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;
            if (Integer.MAX_VALUE / 10 < total ||
                    Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            index++;
        }

        return total * sign;
    }

}
