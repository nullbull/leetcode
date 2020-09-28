package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/9/22 19:35
 * @desc
 */

public class A62不同路径 {

    public int uniquePaths(int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
