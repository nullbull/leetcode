package study.leetcode;

import java.util.Arrays;

/**
 * @author niuzhenhao
 * @date 2021/2/15 13:11
 * @desc
 */
public class A1464数组中两元素的最大成绩 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        int second = nums[nums.length-2];
        return (max-1) * (second-1);
    }
}
