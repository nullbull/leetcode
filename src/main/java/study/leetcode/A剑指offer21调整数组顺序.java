package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/13 12:58
 * @desc
 */
public class A剑指offer21调整数组顺序 {

    public int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }

        for (int i = 0;  i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int p = i + 1;
                while (p < nums.length && nums[p] % 2 == 0) {
                    p++;
                }
                if (p < nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[p];
                    nums[p] = temp;
                }

            }
        }
        return nums;
    }

    public static void main(String[] args) {
        new A剑指offer21调整数组顺序().exchange(new int[]{1,2,3,4});
    }
}
