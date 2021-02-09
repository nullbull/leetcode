package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/2/9 22:15
 * @desc
 */
public class A17电话号码的字母组合 {

    List<String> res = new ArrayList<>();
    String[] numbers = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String s) {
        if (s == null || s .equals("" )) {
            return res;
        }
        dg(s, 0, "");
        return res;
    }

    private void dg(String s, int pos, String cur) {
        if (pos >= s.length()) {
            res.add(new String(cur));
            return;
        }
        int number = s.charAt(pos) - '0';
        if (number != 1) {
            String aa = numbers[number-1];
            for (char c : aa.toCharArray()) {
                cur += c;
                dg(s, pos + 1, cur);
                cur = cur.substring(0, cur.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new A17电话号码的字母组合().letterCombinations("239"));
        System.out.println(new A17电话号码的字母组合().letterCombinations(""));
    }



}
