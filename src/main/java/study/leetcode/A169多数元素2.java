package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/28 11:40
 * @desc
 */
public class A169多数元素2 {

    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = nums[i+1];
            }
        }
        return res;
    }

}
