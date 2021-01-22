package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/22 22:08
 * @desc
 */
public class A704二分查找 {

    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
