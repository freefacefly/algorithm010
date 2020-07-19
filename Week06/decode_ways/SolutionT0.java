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
