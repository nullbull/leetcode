package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/9/28 18:34
 * @desc
 */

public class A72编辑距离 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m][n];
        int mm = 0;
        int nn = 0;
        int max = -1;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > max) {

                    }
                }
            }
        }
        return 0;
    }
}
