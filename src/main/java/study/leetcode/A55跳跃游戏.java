package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/9/2 9:41
 * @desc
 */

public class A55跳跃游戏 {

//    public boolean canJump(int[] nums) {
//
//        if (nums == null || nums.length == 1) {
//            return true;
//        }
//        int end = nums.length - 1;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                break;
//            }
//            for (int j = 0; j <= nums[i] && j + i <= end; j++) {
//                if (j + nums[i + j] >= end){
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        new A55跳跃游戏().canJump(new int[]{2, 3, 1, 1, 4});
//        new A55跳跃游戏().canJump(new int[]{3, 2, 1, 0, 4});
//        new A55跳跃游戏().canJump(new int[]{0, 2, 3});


        new A55跳跃游戏().canJump(new int[]{1, 1, 1, 0});
    }
}
