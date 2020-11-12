package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/11/11 9:55
 * @desc
 */

public class A193打劫 {


  // 1 2 3 1
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        if (nums.length > 2) {
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }

        return dp[nums.length -1];

    }
}
