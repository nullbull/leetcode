package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/14 14:35
 * @desc
 */
public class A剑指offer42连续子数组最大和 {

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1], 0);
            res = Math.max(nums[i], res);
        }
        return res;
    }

//    public int maxSubArray(int[] nums) {
////
////
////
////        int[] dp = new int[nums.length];
////
////        dp[0] = nums[0];
////        for (int i = 1; i < nums.length; i++) {
////           dp[i] = dp[i-1] + nums[i];
////        }
////
////        int max = dp[0];
////        for (int i = 0; i < nums.length; i++) {
////            for (int j = i + 1; j < nums.length; j++) {
////                max = Math.max(dp[j], max);
////                max = Math.max(dp[j]-dp[i], max);
////            }
////        }
////        return max;
////    }
}
