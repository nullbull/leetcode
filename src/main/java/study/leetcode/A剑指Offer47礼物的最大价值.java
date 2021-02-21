package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/21 15:17
 * @desc
 */
public class A剑指Offer47礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && j-1 >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                } else if (i == 0 && j - 1 >= 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j == 0 && i -1 >= 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
