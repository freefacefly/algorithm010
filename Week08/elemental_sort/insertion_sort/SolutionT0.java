package io.kvh.algo.w8.c18.insertion_sort;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvh on 2020/8/1.
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
        List<TestPair<int[], Integer, int[], Integer>> tables = Arrays.asList(
                new TestPair<>(new int[]{30, 2, 10, 4, 40, 20}, null, new int[]{2, 4, 10, 20, 30, 40}, null)
        );

        for (TestPair<int[], Integer, int[], Integer> p : tables) {
            new SolutionT0().sort(p.input1);
            Assert.assertEquals(Arrays.toString(p.expect), Arrays.toString(p.input1));
        }
    }

    private void sort(int[] nums) {
        int len = nums.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = nums[i];
            while (preIndex >= 0 && nums[preIndex] > current) {
                //move back
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
    }
}
