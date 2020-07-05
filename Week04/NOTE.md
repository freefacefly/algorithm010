# 寻找旋转点

```
public static void main(String[] args) {
        int[][] table = new int[][]{
                {4, 5, 6, 7, 0, 1, 2},
                {6, 7, 0, 1, 2, 4, 5},
                {1, 3, 2}
        };

        for (int[] nums : table) {
            int[] ret = new SolutionT0().search(nums);
            for (int i : ret) {
                System.out.println(i);
            }
        }

    }

    public int[] search(int[] nums) {
        int[] empty = new int[2];

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return empty;
        }

        int left = 0;
        int right = nums.length - 1;

        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if ((mid - left) <= 1 && nums[left] > nums[mid]) {
                return new int[]{left, mid};
            }

            if ((right - mid) <= 1 && nums[mid] > nums[right]) {
                return new int[]{mid, right};
            }

            if (nums[left] <= nums[mid] || nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return empty;
    }
```