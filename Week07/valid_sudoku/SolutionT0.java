package io.kvh.algo.w7.c14.valid_sudoku;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by kvh on 2020/7/26.
 * https://leetcode-cn.com/problems/valid-sudoku/
 * 核心是找到对于行、列、块的唯一哈希标示方式
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
        List<TestPair<char[][], int[], Boolean, Integer>> tables = Arrays.asList(
                new TestPair<>(new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}, null, true, null)
                ,
                new TestPair<>(new char[][]{
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}, null, false, null)
        );

        for (TestPair<char[][], int[], Boolean, Integer> p : tables) {
            Assert.assertEquals(p.expect, new SolutionT0().isValidSudoku(p.input1));
        }
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                String b = "(" + board[i][j] + ")";

                //block id : i / 3 + b + j / 3
                if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i / 3 + b + j / 3)) return false;
            }
        }

        return true;
    }

    public boolean isValidSudokuV0(char[][] board) {
        HashMap<Character, Integer>[] rows = new HashMap[9];
        HashMap<Character, Integer>[] cols = new HashMap[9];
        HashMap<Character, Integer>[] blocks = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            blocks[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    rows[i].put(c, rows[i].getOrDefault(c, 0) + 1);
                    cols[j].put(c, cols[j].getOrDefault(c, 0) + 1);
                    int blockIdx = (i / 3) * 3 + j / 3;
                    blocks[blockIdx].put(c, blocks[blockIdx].getOrDefault(c, 0) + 1);

                    if (rows[i].get(c) > 1 || cols[j].get(c) > 1 || blocks[blockIdx].get(c) > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
