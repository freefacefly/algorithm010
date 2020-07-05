package io.kvh.algorithm.w4.c10.jump_game_ii;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/7/4.
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

        @Override
        public String toString() {
            return "TestPair{" +
                    "input1=" + input1 +
                    ", input2=" + input2 +
                    ", expect=" + expect +
                    ", target=" + target +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<SolutionT0.TestPair<int[], int[], Integer, Integer>> tables = Arrays.asList(
                new SolutionT0.TestPair<>(new int[]{2, 3, 1, 1, 4}, null, 2, null)
                ,
                new SolutionT0.TestPair<>(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}, null, 2, null)
                ,
                new SolutionT0.TestPair<>(new int[]{0}, null, 0, null)
                ,
                new SolutionT0.TestPair<>(new int[]{1, 1, 2, 2, 2}, null, 3, null)
        );

        for (TestPair<int[], int[], Integer, Integer> p : tables) {
            System.out.println(p);
            Assert.assertEquals((long) p.expect, new SolutionT0().jumpV0(p.input1));
        }
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int end = 0;//next stop
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //iterate the next few
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {//meet stop sign, jump the max
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }


    public int jumpV0(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int jumps = 0;
        for (int i = 0; i < nums.length; ) {
            int steps = nums[i];
            //判断能直接到达，返回
            if (steps + i >= nums.length - 1) {
                jumps++;
                break;
            }

            int reach = 0;
            int nextMove = 1;
            for (int s = 1; s <= steps; s++) {
                int nextReach = s + nums[i + s];
                if (nextReach >= reach) {
                    reach = nextReach;
                    nextMove = s;
                }
            }

            i += nextMove;
            jumps++;
        }

        return jumps;
    }
}
