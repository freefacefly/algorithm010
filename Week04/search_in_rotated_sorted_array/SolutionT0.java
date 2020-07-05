package io.kvh.algorithm.w4.c11.search_in_rotated_sorted_array;

/**
 * Created by kvh on 2020/7/3.
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SolutionT0 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        int target = 1;

        int ret = new SolutionT0().search(nums, target);

        System.out.println(ret);
    }

    /**
     * 分割方式
     * [0,1,2,3,4,5,6]
     * ->
     * [3,4,5,6|0,1,2,3]
     * [5,6,0,1|2,3,4,5]
     *
     * 要么是左侧有序，要么是右侧有序
     *
     * 区分两种情况：
     * 1)左半部分有序 num[left]<=num[mid]
     *
     * 1-1 num[left]<=target<num[mid]
     *
     * 1=2 other
     *
     * 2)右半部分有序 num[left]>num[mid]
     *
     * 2-1 num[mid]<target<=nums[right]
     *
     * 2-2 other
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
