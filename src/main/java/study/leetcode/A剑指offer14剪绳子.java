package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/21 10:47
 * @desc
 */
public class A剑指offer14剪绳子 {

    public int cuttingRope(int n) {
        int dp[] = new int[n+1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i-j) * j, (dp[i-j] * j)));
            }
        }
        return dp[n];
    }
}
