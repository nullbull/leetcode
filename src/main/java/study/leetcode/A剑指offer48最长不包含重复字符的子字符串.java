package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/21 15:58
 * @desc
 */
public class A剑指offer48最长不包含重复字符的子字符串 {

    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();

        int[] map = new int[128];
        int max = 0;
        int start = -1;
        for (int i = 0; i < 128; i++) {
            map[i] = -1;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (map[c] != -1) {
                start = Math.max(map[c], start );
                map[c] = i;
            } else {
                map[c] = i;
            }
            max = Math.max(i - start, max);


        }
        return max;

    }

    public static void main(String[] args) {
        new A剑指offer48最长不包含重复字符的子字符串().lengthOfLongestSubstring("pwwkew");
    }
}
