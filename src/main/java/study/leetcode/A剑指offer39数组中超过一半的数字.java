package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/7 23:27
 * @desc
 */
public class A剑指offer39数组中超过一半的数字 {


    public int majorityElement(int[] nums) {
        int x = 0;
        int vote = 0;
        for (int i : nums) {
            if (vote == 0) {
                x = i;
            }
            vote += x == i ? 1 : -1;
        }
        return x;
    }
}
