package study.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author niuzhenhao
 * @date 2021/2/12 22:06
 * @desc
 */
public class A3复习 {

    public int lengthOfLongestSubstring(String s) {

        int dp[][] = new int[s.length()+1][s.length()+1];
        for (int i = 1; i < s.length();i ++) {
            dp[i][i] = 1;
        }
        int max = - 1;
        char[] c = s.toCharArray();
        Set<Character> has = new HashSet<>();
        for (int i = 0; i < c.length; i++) {
            has.add(c[i]);
            for (int j = i + 1; j < c.length; j++) {
                if (c[i] == c[j]) {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                } else {
                    if (!has.contains(c[j])) {
                        dp[i+1][j+1] = dp[i+1][j] + 1;
                        has.add(c[j]);
                    }
                }
             max = Math.max(dp[i][j], max);
            }
            has.remove(c[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(new A3复习().lengthOfLongestSubstring("abcabcde"));
    }
}
