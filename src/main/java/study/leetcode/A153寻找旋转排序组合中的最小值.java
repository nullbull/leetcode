package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/12 23:28
 * @desc
 */
public class A153寻找旋转排序组合中的最小值 {
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                return nums[i+1];
            }
        }
        return nums[0];
    }
}
