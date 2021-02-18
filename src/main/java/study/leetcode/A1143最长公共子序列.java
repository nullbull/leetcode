package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/3 10:48
 * @desc
 */

public class A1143最长公共子序列 {
    public int longestCommonSubsequence(String s1, String s2) {
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if (c1[i] == c2[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[s1.length()][s2.length()];

    }
}
