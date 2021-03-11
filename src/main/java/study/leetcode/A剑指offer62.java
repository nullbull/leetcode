package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/8 22:02
 * @desc
 */
public class A剑指offer62 {

    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
