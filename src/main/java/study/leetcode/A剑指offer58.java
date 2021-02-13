package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/13 12:54
 * @desc
 */
public class A剑指offer58 {
    public String reverseLeftWords(String s, int n) {
        n = n % s.length();
        char[] c = s.toCharArray();
        String res = "";
        for (int i = n; i < c.length; i++) {
            res += c[i];
        }
        for (int i = 0; i < n; i++) {
            res += c[i];
        }
        return res;
    }
}
