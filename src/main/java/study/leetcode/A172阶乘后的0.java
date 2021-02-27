package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/27 14:30
 * @desc
 */
public class A172阶乘后的0 {


    public int trailingZeroes(int n) {
        int zeroCount = 0;
        long five = 5;
        while (five <= n) {
            zeroCount += n / five;
            five = five * 5;
        }
        return zeroCount;

    }

    public static void main(String[] args) {
        new A172阶乘后的0().trailingZeroes(30);
    }
}
