package io.kvh.algorithm.w4.c11.search_a_2d_matrix;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

class SolutionT0 {

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
        List<TestPair<int[][], int[], Boolean, Integer>> tables = Arrays.asList(
                new TestPair<>(new int[][]{
                        new int[]{1, 3, 5, 7},
                        new int[]{10, 11, 16, 20},
                        new int[]{23, 30, 34, 50}
                }, null, true, 3)
                ,
                new TestPair<>(new int[][]{
                        new int[]{1, 3, 5, 7},
                        new int[]{10, 11, 16, 20},
                        new int[]{23, 30, 34, 50}
                }, null, false, 13)
                ,
                new TestPair<>(new int[][]{
                        new int[]{1, 3}
                }, null, true, 3)
                ,
                new TestPair<>(new int[][]{
                        new int[]{1, 3}
                }, null, false, 4)
                ,
                new TestPair<>(new int[][]{
                        new int[]{1},
                        new int[]{3}
                }, null, true, 3)
                ,
                new TestPair<>(new int[][]{
                        new int[]{1, 3, 5, 7},
                        new int[]{10, 11, 16, 20},
                        new int[]{23, 30, 34, 50}
                }, null, true, 11)
        );


        for (TestPair<int[][], int[], Boolean, Integer> p : tables) {
            System.out.println(Arrays.toString(p.input1));
            Assert.assertEquals(p.expect, new SolutionT0().searchMatrix(p.input1, p.target));
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        if (n == 0) {
            return false;
        }

        int left = 0, right = m * n - 1;
        int midIdx, midVal;
        while (left <= right) {
            midIdx = left + (right - left) / 2;
            midVal = matrix[midIdx / n][midIdx % n];
            if (target == midVal) {
                return true;
            } else if (target > midVal) {
                left = midIdx + 1;
            } else if (target < midVal) {
                right = midIdx - 1;
            }
        }

        return false;
    }

    public boolean searchMatrixV0(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        if (n == 0) {
            return false;
        }

        int[] haystack = null;
        for (int[] ints : matrix) {
            int head = ints[0];
            int tail = ints[ints.length - 1];
            if (head <= target && target <= tail) {
                haystack = ints;
            }
        }

        if (haystack == null) {
            return false;
        }

        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int midVal = haystack[mid];
            if (target < midVal) {
                right = mid - 1;
            } else if (target > midVal) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
