package io.kvh.algo.w7.c14.sudoku_solver;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;


/**
 * Created by kvh on 2020/7/26.
 * https://leetcode-cn.com/problems/sudoku-solver/
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
        );

        for (TestPair<char[][], int[], Boolean, Integer> p : tables) {
            new SolutionT0().solveSudoku(p.input1);
        }
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            //backtrace
                            else board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            //c not occur
            if (board[row][i] != '.' && board[row][i] == c) return false;
            if (board[i][col] != '.' && board[i][col] == c) return false;

            int br = row / 3 * 3 + i / 3;
            int bc = col / 3 * 3 + i % 3;
            if (board[br][bc] != '.' && board[br][bc] == c) return false;

        }
        return true;
    }

}
