package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/16 19:43
 * @desc
 */
public class A31下一个排列 {


    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean isSuccess = false;
        for (int i = n - 1; i > 0 ;i --) {
            if (nums[i] > nums[i-1]) {
                int p = i;
                for (int j = n - 1; j > i; j--) {
                    if (nums[j] > nums[i-1]) {
                        p = j;
                        break;
                    }
                }
                swap(nums, i-1, p);
                for (int k = i, j = n - 1; k < j; k++,j--) {
                    swap(nums, k, j);
                }
                isSuccess = true;
                break;
            }
        }
        if (!isSuccess) {
            for (int i = 0, j = n - 1; i < j; i++,j--) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        new A31下一个排列().nextPermutation(new int[]{5, 4, 7, 5, 3, 2});
        new A31下一个排列().nextPermutation(new int[]{1,2,3});
    }
}
