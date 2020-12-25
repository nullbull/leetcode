package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/12/25 19:02
 * @desc  ac
 */

public class A183旋转数组 {
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length -1];
            for (int j = nums.length- 1; j >= 1; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7};
        rotate(a, 0);
        for (int aa :a ) {
            System.out.print(aa);
        }
    }
}
