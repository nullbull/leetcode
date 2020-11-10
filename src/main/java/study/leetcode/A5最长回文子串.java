package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/11/10 19:25
 * @desc
 */

public class A5最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean dp[][] = new boolean[len][len];

        int max = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i < len - 1 && chars[i] == chars[i + 1]) {
                dp[i][i + 1] = true;
                max = 1;
            }
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (!dp[i][j]){
                    if (chars[i] == chars[j]) {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j]) {
                    max = Math.max(max, j - i);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (dp[i][j] && j - i == max) {
                    return s.substring(i, j + 1);
                }
            }
        }


        return "";
    }

    public static void main(String[] args) {
        System.out.println(new A5最长回文子串().longestPalindrome("cbbd"));
    }
}
