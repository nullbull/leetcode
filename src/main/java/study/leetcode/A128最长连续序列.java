package study.leetcode;

import java.util.Arrays;

/**
 * @author niuzhenhao
 * @date 2021/2/14 23:11
 * @desc
 */
public class A128最长连续序列 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int begin = i;
            int repeatCount = 0;
            while (j < nums.length && i < nums.length && nums[j] - nums[i] <= 1) {
                if (nums[j] == nums[i]) {
                    repeatCount++;
                }
                i++;
                j++;
            }
            max = Math.max(j - begin - repeatCount, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new A128最长连续序列().longestConsecutive(new int[]{0, 1, 1,2}));
    }
}
