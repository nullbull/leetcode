package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/28 16:10
 * @desc
 */
public class A922按久排序数组2 {

    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0 && nums[i] % 2 == 1) {
                int p = i + 1;
                while (p < nums.length && nums[p] % 2 == 1) {
                    p += 2;
                }
                swap(nums, i, p);
            }
            if (i % 2 == 1 && nums[i] % 2 == 0) {
                int p = i + 1;
                while (p < nums.length && nums[p] % 2 == 0) {
                    p += 2;
                }
                swap(nums, i, p);
            }
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
