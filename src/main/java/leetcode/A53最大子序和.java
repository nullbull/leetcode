package leetcode;

import java.util.Stack;

/**
 * @author niuzhenhao
 * @date 2020/9/1 9:59
 * @desc
 */

public class A53最大子序和 {
    //错误代码
/*    public int maxSubArray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.add(nums[0]);
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (i < nums.length -1 && sum > max) {
                max = sum;
                sum += nums[++i];
            }
            if ( sum < 0 && sum  < max) {
                sum = 0;
            }
        }
        return max;
    }*/
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        new A53最大子序和().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
//        new A53最大子序和().maxSubArray(new int[]{-2, -1});
    }
}
