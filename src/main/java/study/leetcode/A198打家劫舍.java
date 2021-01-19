package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/19 21:29
 * @desc
 */
public class A198打家劫舍 {
    public int rob(int[] nums) {
        int max = 0 ;
        if (nums == null) {
            return max;
        }
        int n = nums.length;
        if ( n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];


        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i ++) {
           dp[i] = Math.max(  nums[i] + dp[i-2], dp[i-1]);
           max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int rob = new A198打家劫舍().rob(new int[]{2, 10, 9, 3, 1});
        System.out.println(rob);
    }
}
