package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/6 19:34
 * @desc
 */
public class A剑指offer56I数组中只出现一次的数字2 {

    public int[] singleNumbers(int[] nums) {
        int k = 0;
        int m = 1;
        for (int i : nums) {
            k ^= i;
        }
        while ((m & k) == 0) {
            m <<= 1;
        }
        int x = 0, y = 0;
        for (int i : nums) {
            if ((i & m) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        return new int[]{x, y};

    }
}
