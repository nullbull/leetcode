package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/21 12:47
 * @desc
 */
public class A剑指offer64 {
    public int sumNums(int n) {
        return dg(n);
    }

    public int dg(int n) {
        boolean x = n > 0 && (n + dg(n-1)) > 0;
        return n;
    }
}
