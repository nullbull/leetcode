package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/13 12:34
 * @desc
 */
public class A69复习 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long left = 1;
        long right = x / 2;
        long mid = 1;
        while (left  <= right) {
             mid = (left + right) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x && (mid-1) * (mid-1) < x) {
                return (int)mid-1;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int)mid;
    }

    public static void main(String[] args) {
        System.out.println( new A69复习().mySqrt(2147395599));
    }
}
