package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/17 20:18
 * @desc
 */
public class A3最长不重复字串 {

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];

        char[] cs = s.toCharArray();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++)  {
            start = Math.max(map[cs[i]], start);
            max = Math.max(i - start + 1, max);
            map[cs[i]] = i;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new A3最长不重复字串().lengthOfLongestSubstring("abcdbb"));
    }
}
