package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/11/14 17:03
 * @desc
 */

public class A14最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String first = strs[0];

        int count = 0;
        if (first.length() > 0) {
            boolean same = true;
            while (same && count < first.length()) {
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() > 0 && count < strs[i].length()) {
                        if (strs[i].charAt(count) != first.charAt(count)) {
                            same = false;
                            break;
                        }
                    } else {
                        same = false;
                        break;
                    }
                }
                if (same == true) {
                    count++;
                }
            }
        }

        String res = "";
        for (int i = 0; i < count; i++) {
            res += first.charAt(i);
        }
        return res;
    }
}
