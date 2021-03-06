package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/6 19:15
 * @desc
 */
public class A191位1的个数 {


    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
