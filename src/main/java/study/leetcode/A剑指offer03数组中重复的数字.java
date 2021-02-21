package study.leetcode;

import java.util.Arrays;

/**
 * @author niuzhenhao
 * @date 2021/2/21 13:18
 * @desc
 */
public class A剑指offer03数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return nums[i];
            }
        }

        return nums[0];
    }
}
