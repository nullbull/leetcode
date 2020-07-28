package leetcode;

/**
 * @author niuzhenhao
 * @date 2020/7/28 19:10
 * @desc
 */

public class A27 {
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1;) {
            if (nums[i] != nums[i + 1]) {
                count ++;
            } else {
                int start = i;
                while (nums[i] == nums[++i]) { }
                int l = i - start - 1;
                for (int j = start + 1; j < i; j++) {
                    nums[j] = nums[j + l];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,2});
    }
}
