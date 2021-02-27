package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/23 23:20
 * @desc
 */
public class A50Pow {

    public double myPow(double x, int n) {
        long z = Math.abs(n);
        double res = 1.0;
        for (long i = z; i != 0; i /= 2) {
            if ((i % 2) == 1) {
                res *= x;
            }
            x = x * x;
        }
        return n > 0 ? res : 1.0 / res;
    }

    public static void main(String[] args) {
        System.out.println(new A50Pow().myPow(2.0, 10));
    }


}
