package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/9 20:55
 * @desc
 */
public class A5最长回文字串复习 {

    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[c.length+1][c.length+1];
        for (int i = 0; i < c.length; i++) {
            dp[i][i] = true;
        }
        int maxL = 0;
        int left = 0;
        int right = 0;
        for (int j = 1; j < c.length; j++) {
            for (int i = 0; i < j; i++) {
                if (c[i] == c[j]) {
                    if (j - i > 2 && dp[i+1][j-1]) {
                        dp[i][j] = true;
                    } else if (j-i <= 2) {
                        dp[i][j] = true;
                    }
                    if (dp[i][j]) {
                        if (j-i > maxL) {
                            maxL = j-i;
                            left = i;
                            right = j;
                        }
                    }

                } else {
                    dp[i+1][j+1] = false;
                }

            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        System.out.println(new A5最长回文字串复习().longestPalindrome("babcad"));
        System.out.println(new A5最长回文字串复习().longestPalindrome("cbbd"));
        System.out.println(new A5最长回文字串复习().longestPalindrome("cccc"));
        System.out.println(new A5最长回文字串复习().longestPalindrome("abcba"));


    }
}
