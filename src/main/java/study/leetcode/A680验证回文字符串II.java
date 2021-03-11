package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/10 22:29
 * @desc
 */
public class A680验证回文字符串II {


    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return isValid(chars, i + 1, j) || isValid(chars, i + 1, j -1);
            }
        }
        return true;
    }

    public boolean isValid(char[] chars, int i, int j) {
        while (i <= j) {
           if (chars[i] == chars[j]) {
               i++;
               j--;
           } else {
               return false;
           }
        }
        return true;
    }


}
