package io.kvh.algorithm.w4.c10.lemonade_change;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/7/4.
 * https://leetcode-cn.com/problems/lemonade-change
 */
public class SolutionT0 {
    public static class TestPair<I, E, T> {
        final private I input;
        final private E expect;
        final private T target;

        public TestPair(I input, E expect, T target) {
            this.input = input;
            this.expect = expect;
            this.target = target;
        }
    }

    public static void main(String[] args) {
        List<TestPair<int[], Boolean, Integer>> tables = Arrays.asList(
//                new TestPair<>(new int[]{5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 20}, true, null)
//                , new TestPair<>(new int[]{5, 5, 10}, true, null)
//                , new TestPair<>(new int[]{10, 10}, false, null)
//                , new TestPair<>(new int[]{5, 5, 5, 10, 20}, true, null)
                new TestPair<>(new int[]{5, 5, 10, 10, 20}, false, null)
        );

        for (TestPair<int[], Boolean, Integer> p : tables) {
            Assert.assertEquals(p.expect, new SolutionT0().lemonadeChange(p.input));
        }
    }

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }

        int rmb5 = 0;
        int rmb10 = 0;
        for (int bill : bills) {
            int exchange = bill - 5;

            //not enough to payback
            if (rmb5 * 5 + rmb10 * 10 < exchange) {
                return false;
            }

            while (exchange > 0) {
                //need >= 10, use 10 in first place
                if (exchange >= 10 && rmb10 > 0) {
                    exchange -= 10;
                    rmb10--;
                } else if (rmb5 > 0) {//use 5
                    exchange -= 5;
                    rmb5--;
                } else {//unable to payback
                    return false;
                }
            }

            if (bill == 5) {
                rmb5++;
            } else if (bill == 10) {
                rmb10++;
            }
        }

        return true;
    }
}
