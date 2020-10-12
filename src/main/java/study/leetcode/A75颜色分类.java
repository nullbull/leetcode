package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/10/10 18:15
 * @desc
 */

public class A75颜色分类 {

    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int i = 0;
        int j = nums.length - 1;
        int count = 0;
//        while (i < j && count <= j ) {
//            if (nums[count] == 2) {
//                int temp = nums[j];
//                nums[j--] = 2;
//                nums[count] = temp;
//            }
//            if (nums[count] == 0) {
//                int temp = nums[i];
//                nums[i++] = 0;
//                nums[count] = temp;
//            }
//            count++;
//
//        }
        for (int k = i; k <= j; k++) {
            if (nums[k] == 0) {
                nums[k] = nums[i];
                nums[i++] = 0;
            }
            if (nums[k] == 2) {
                nums[k] = nums[j];
                nums[j--] = 2;
                k--;
            }
        }

    }


    public static void main(String[] args) {
//        new A75颜色分类().sortColors(new int[]{2, 1, 0, 2, 0, 1});
        new A75颜色分类().sortColors(new int[]{2, 1, 2});
        // 1 1 0 2 0 2
        // 1 1 0 2 0 2
        // 0 1 1 2 0 2
        // 0 1 1 0 2 2

    }

}
