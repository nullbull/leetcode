package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/13 17:18
 * @desc
 */
public class A31下一个排列复习 {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int p = i;
                while (p < n && nums[p] > nums[i-1]) {
                    p++;
                }
                p--;
                swap(nums, i - 1, p);
                int j = n - 1;
                p = i;
                while (p < j) {
                    swap(nums, p, j);
                    p++;
                    j--;
                }
                return;
            }
        }
        int k = 0;
        n = n - 1;
        while (k < n) {
            swap(nums, k++, n--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        new A31下一个排列复习().nextPermutation(new int[]{2, 3, 1});
    }

}
