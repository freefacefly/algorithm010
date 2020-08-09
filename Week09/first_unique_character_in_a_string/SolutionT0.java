package io.kvh.algo.w9.c20.first_unique_character_in_a_string;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kvh on 2020/8/4.
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
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
                new TestPair<>("leetcode", null, 0, null)
                ,
                new TestPair<>("loveleetcode", null, 2, null)
        );

        for (TestPair<String, int[], Integer, Integer> p : tables) {
            Assert.assertEquals((int) p.expect, new SolutionT0().firstUniqChar(p.input1));
        }
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int n = map.getOrDefault(c, 0);
            map.put(c, ++n);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
