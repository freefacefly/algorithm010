package io.kvh.algorithm.w2.c5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kvh on 2020/6/21.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        //put map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        //loop check map.get(target-item) exist
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            int k = target - item;
            Integer v = map.get(k);

            if (v != null) {
                if (i == v) {
                    continue;
                }
                return new int[]{i, v};
            }
        }

        return new int[]{};
    }
}
