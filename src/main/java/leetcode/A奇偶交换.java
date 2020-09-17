package leetcode;

/**
 * @author niuzhenhao
 * @date 2020/9/17 13:49
 * @desc
 */

public class A奇偶交换 {

    public int[] exchange(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int p = i;
                while (i < nums.length - 1 && nums[++i] % 2 == 0) { }
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                i = p;
            }
        }
        return nums;
    }



    public static void main(String[] args) {
//        new A奇偶交换().exchange(new int[]{1, 2, 3, 4, 5});
        new A奇偶交换().exchange(new int[]{2, 4, 6, 3, 5});
    }
}
