package leetcode;

public class A35搜索插入位置 {
    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int temp = nums[mid] - target;
            if (temp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right == 0 || right == -1) {
            if (nums[0] < target) {
                return 1;
            }
            return 0;
        }
        if (left == nums.length - 1) {
            if (nums[left] > target) {
                return left;
            }
            return nums.length;
        }



        return left;
    }

    public static void main(String[] args) {
        System.out.println(new A35搜索插入位置().searchInsert(new int[]{1, 2, 4, 5, 7}, 6));
    }

}
