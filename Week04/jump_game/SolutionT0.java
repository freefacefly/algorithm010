package io.kvh.algorithm.w4.c10.jump_game;

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
        List<SolutionT0.TestPair<int[], int[], Boolean, Integer>> tables = Arrays.asList(
//                new SolutionT0.TestPair<>(new int[]{2, 3, 1, 1, 4}, null, true, null)
//                ,
                new SolutionT0.TestPair<>(new int[]{3, 2, 1, 0, 4}, null, false, null)
        );

        for (TestPair<int[], int[], Boolean, Integer> p : tables) {
            System.out.println(p);
            Assert.assertEquals(p.expect, new SolutionT0().canJump(p.input1));
        }
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reach < i) return false;
            reach = Math.max(reach, i + nums[i]);
        }

        return true;
    }
}
