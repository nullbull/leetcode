package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/14 22:54
 * @desc
 */
public class A283移动0 {


    public void moveZeroes(int[] nums) {
//        int i = 0;
//        int j = 0;
//        while (i <= j) {
//            if (nums[i] == 0) {
//                nums[i] = nums[j];
//                nums[j] = 0;
//                j--;
//            } else {
//                i++;
//            }
//        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int p = i + 1;
                while (p < nums.length && nums[p] == 0) {
                    p++;
                }
                if (p < nums.length) {
                    nums[i] = nums[p];
                    nums[p] = 0;
                }

            }
        }
//        for (int i : nums) {
//            System.out.print(i + " ");
//        }
    }

    public static void main(String[] args) {
        new A283移动0().moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
