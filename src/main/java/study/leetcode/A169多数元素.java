package study.leetcode;

import java.util.HashMap;

/**
 * @author niuzhenhao
 * @date 2020/11/12 19:33
 * @desc
 */

public class A169多数元素 {
    public int majorityElement(int[] nums) {
        HashMap<Integer ,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            Integer count = map.getOrDefault(now, 0);
            count++;
            if (count > nums.length / 2) {
                return now;
            }
            map.put(now, count);
        }
        return 0;

    }

    public static void main(String[] args) {

    }

}
