package io.kvh.algorithm.w2.c5;

import java.util.Arrays;

/**
 * Created by kvh on 2020/6/21.
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";


        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        //handle input
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int totalLength = 26;

        //put s in table s
        int[] tableS = new int[totalLength];
        for (char c : s.toCharArray()) {
            tableS[c]++;
        }

        //put t in table t
        int[] tableT = new int[totalLength];
        for (char c : t.toCharArray()) {
            tableT[c]++;
        }

        //compare two table
        for (int i = 0; i < totalLength; i++) {
            if (tableS[i] != tableT[i]) {
                return false;
            }
        }

        return true;
    }
}
