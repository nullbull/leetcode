package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/8 23:09
 * @desc
 */
public class 剑指Offer53I在排序数组中查找数字I {



    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                int p = mid;
                while (p >= 0 && nums[p] == target) {
                    count++;
                    p--;
                }
                p = mid + 1;
                while (p < nums.length  && nums[p] == target) {
                    count++;
                    p++;
                }
                 return count;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return count;
    }
}
