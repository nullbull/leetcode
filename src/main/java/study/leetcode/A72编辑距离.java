package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/9/28 18:34
 * @desc
 */

public class A72编辑距离 {
    public int minDistance(String word1, String word2) {


        if ((word1 == null || word1.length() == 0)&& word2 != null) {
            return word2.length();
        }
        if ((word2 == null || word2.length() == 0)&& word1 != null) {
            return word1.length();
        }

        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        int m = c1.length;
        int n = c2.length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i-1] != c2[j-1]) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        System.out.println(new A72编辑距离().minDistance("horse", "ros"));
    }
}
