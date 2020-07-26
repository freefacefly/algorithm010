package io.kvh.algo.w4.c9.generate_parentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kvh on 2020/7/1.
 * https://leetcode-cn.com/problems/generate-parentheses
 */
public class SolutionT0 {
    public static void main(String[] args) {
        List<String> list = new SolutionT0().generateParenthesis(3);
        System.out.println(list);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n == 0) {
            return res;
        }
        dfs(res, "", n, n);
        return res;
    }

    /**
     * 产生左子树条件：left>0
     * 产生右子树条件：right>=left
     *
     * @param res
     * @param sub
     * @param left 剩余左括号
     * @param right 剩余右括号
     */
    public void dfs(List<String> res, String sub, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sub);
            return;
        }

        //** left <= right
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(res, sub + "(", left - 1, right);
        }

        if (right > 0) {
            dfs(res, sub + ")", left, right - 1);
        }

    }

    public List<String> generateParenthesisT0(int n) {
        List<String> res = new LinkedList<>();
        generateAll(res, new char[2 * n], 0);
        return res;
    }

    private void generateAll(List<String> res, char[] curr, int pos) {
        if (curr.length == pos) {
            if (valid(curr)) {
                res.add(new String(curr));
            }
            return;
        }

        curr[pos] = '(';
        generateAll(res, curr, pos + 1);
        curr[pos] = ')';
        generateAll(res, curr, pos + 1);
    }

    private boolean valid(char[] chars) {
        int balance = 0;
        for (char c : chars) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }


}
