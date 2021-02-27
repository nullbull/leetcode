package study.leetcode;

import java.util.Collections;

/**
 * @author niuzhenhao
 * @date 2021/2/27 18:06
 * @desc
 */
public class A977有序数组的平方 {



    public int[] sortedSquares(int[] nums) {
        int p = 0;
        boolean find = false;
        int first = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (!find && nums[i] >= 0) {
                p = i;
                find = true;
            }
            nums[i] *= nums[i];
        }

        if (!find) {
            if (first < 0) {
                int i = 0;
                int j = nums.length - 1;
                while (i < j) {
                    swap(nums, i, j);
                    i++;
                    j--;
                }
                return nums;

            } else {
                return nums;

            }
        }

        int[] res = new int[nums.length];
        int count = 0;
        int i = p - 1;
        int j = p;
        while (i >= 0 && j < nums.length) {
            if (nums[i] > nums[j]) {
                res[count++] = nums[j];
                j++;
            } else {
                res[count++] = nums[i];
                i--;
            }
        }
        while (i >= 0) {
            res[count++] = nums[i--];
        }
        while (j < nums.length) {
            res[count++] = nums[j++];

        }

        return res;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
