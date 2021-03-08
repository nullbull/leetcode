package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/7 12:02
 * @desc
 */
public class A3复习复习 {


    public int lengthOfLongestSubstring(String s) {

        int[] map = new int[128];
        int start = -1;
        char[] c = s.toCharArray();
        int max = 0;
        for (int i = 0 ; i < c.length; i++) {
            char cur = c[i];
            start = Math.max(map[cur] + 1, start);
            max = Math.max(max, i - start + 1);
            map[cur] = i;
        }
        return max;

    }





}
