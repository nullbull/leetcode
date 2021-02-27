package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/27 15:10
 * @desc
 */
public class A516最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        char[] c = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (c[i] == c[j]) {
                   dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new A516最长回文子序列().longestPalindromeSubseq("bbbab"));
    }
}
