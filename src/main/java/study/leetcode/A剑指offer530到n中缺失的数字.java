package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/7 23:07
 * @desc
 */
public class A剑指offer530到n中缺失的数字 {
    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
