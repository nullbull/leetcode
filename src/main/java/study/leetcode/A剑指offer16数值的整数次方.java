package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/21 15:36
 * @desc
 */
public class A剑指offer16数值的整数次方 {

    public double myPow(double x, int n) {
        int c = Math.abs(n);
        double res = 1.0;
        for (int i = c; i != 0; i /= 2) {
            if ((i & 1) == 1) {
                res *= x;
            }
            x *= x;
        }
        if (n < 0) {
            return 1.0 / res;
        }
        return res;
    }

    public static void main(String[] args) {
        new A剑指offer16数值的整数次方().myPow(2, 10);
    }
}
