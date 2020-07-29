package leetcode;

/**
 * @author niuzhenhao
 * @date 2020/7/29 19:42
 * @desc
 */

public class A27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            if (now == val) {
                j++;
            }

        }

        return nums.length - j;
    }

    public static void main(String[] args) {
        System.out.println(new A27().removeElement(new int[]{0,1,2,2,3,0,4,2}, 3));
    }
}
