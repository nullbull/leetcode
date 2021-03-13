package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/11 22:11
 * @desc
 */
public class A260只出现一次的数字III {



    public int[] singleNumber(int[] nums) {
        int x = 0;
        int z = 1;
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i];
        }
        while ((z & x) == 0) {
            z <<= 1;
        }
        int a = 0, b = 0;
        for (int i : nums) {
            if ((i & z) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};



    }
}
