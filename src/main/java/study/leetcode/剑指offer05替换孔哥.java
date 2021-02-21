package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/15 17:26
 * @desc
 */
public class 剑指offer05替换孔哥 {

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = "";
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                res += "%20";
            } else {
                res += c[i];
            }
        }
        return res;
    }
}
