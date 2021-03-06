package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/6 17:06
 * @desc
 */
public class A剑指offer33二叉搜索树的后续遍历序列 {

    public boolean verifyPostorder(int[] nums) {
        if (nums.length < 2) return true;
        return dg(nums, 0, nums.length - 1);
    }

    private boolean dg(int[] nums, int l, int r) {
        if (l >= r) {
            return true;
        }

        int mid = nums[r];
        int b = l;

        while (b < r && nums[b] < mid) {
            b++;
        }

        for (int i = b; i < r; i++) {
            if (nums[i] <  mid) {
                return false;
            }
        }

        if (!dg(nums, l, b - 1)) {
            return false;
        }
        if (!dg(nums, b, r - 1)) {
            return false;
        }
        return true;
    }


}
