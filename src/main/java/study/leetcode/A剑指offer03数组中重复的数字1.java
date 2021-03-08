package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/7 10:38
 * @desc
 */
public class A剑指offer03数组中重复的数字1 {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] > nums[j]) {
                i++;
            } else if (nums[i] < nums[j]) {
                j--;
            }else {
                return nums[i];
            }
        }
        return 0;
    }
}
