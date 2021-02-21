package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/17 13:26
 * @desc
 */
public class A213打家劫舍2 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int max = dp[0];
        if (nums.length > 2) {
            dp[0] = nums[0];
            dp[1] = nums[1];
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

}
