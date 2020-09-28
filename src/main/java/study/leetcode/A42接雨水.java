package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/8/21 17:30
 * @desc
 */

public class A42接雨水 {
    public int trap(int[] height) {

        if (height == null) {
            return 0;
        }
        if (height.length == 0 || height.length == 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        int sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                sum += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                sum += rightMax - height[right];
                right--;
            }
        }



        return sum;
    }

    public static void main(String[] args) {

    }
}
