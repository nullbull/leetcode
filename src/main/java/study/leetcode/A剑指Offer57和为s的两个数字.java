package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/2/21 12:33
 * @desc
 */
public class A剑指Offer57和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];





        for (int i = 0; i < nums.length; i++) {
            if (find(nums, target - nums[i], i + 1)) {
                res[0] = nums[i];
                res[1] = target - nums[i];
                break;
            }
        }

        return res;
    }

    private boolean find(int[] nums, int t, int left) {
        int i = left;
        int j = nums.length-1;
        int mid = 0;

        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == t) {
                return true;
            } else if (nums[mid] < t) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}
