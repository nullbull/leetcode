package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/12 22:39
 * @desc
 */
public class A459重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {

        if (s.length() == 1) {
            return false;
        }

        char[] c = s.toCharArray();
        char first = c[0];
        int pos = 0;
        boolean res = false;
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            res = true;
            if (i*2-1 < s.length() && first == c[i] && c[i-1] == c[i*2-1]) {
                pos = i;
                if (s.length() % pos != 0) {
                    continue;
                }
                String all = s.substring(0, pos);
                for (int j = pos; j < s.length(); j+= pos) {
                    String compare = s.substring(j, j + pos);
                    if (!all.equals(compare)) {
                        res = false;
                        break;
                    }
                }
                if (res) {
                    return res;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new A459重复的子字符串().repeatedSubstringPattern("aaac"));
    }
}
