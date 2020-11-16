package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/11/16 19:40
 * @desc
 */

public class A283移动零 {

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            int now = i + 1;
            if (nums[i] == 0) {
                while (now < nums.length && nums[now] == 0) {now++;}
                if (now < nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[now];
                    nums[now] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        new A283移动零().moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
