package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/22 14:14
 * @desc
 */

public class A739每日温度 {
    public int[] dailyTemperatures(int[] nums) {
        int cur = 0;
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int p = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    p = j - i;
                    break;
                }
            }
            res[cur++] = p;
        }
        return res;
    }
}
