package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A电话号码的数字组合 {

    public static List<String> letterCombinations(String digits) {

        if (null == digits || digits.isEmpty()) {
            return new ArrayList<>();
        }
        char p[][] = new char[8][];
        p[0] = new char[]{'a', 'b', 'c'};
        p[1] = new char[]{'d', 'e', 'f'};
        p[2] = new char[]{'g', 'h', 'i'};
        p[3] = new char[]{'j', 'k', 'l'};
        p[4] = new char[]{'m', 'n', 'o'};
        p[5] = new char[]{'p', 'q', 'r', 's'};
        p[6] = new char[]{'t', 'u', 'v'};
        p[7] = new char[]{'w', 'x', 'y', 'z'};
        
        List<String> ans = new ArrayList<>();

        helper(0, ans, p, digits.toCharArray(), "");
        return ans;
    }
    
    public  static void helper(int index, List<String> ans, char[][]p, char[] num, String now) {
        if (index == num.length) {
            ans.add(now);
        } else {
            char[] chars = p[num[index] - 48 - 2];
            for (int i = 0; i < chars.length; i++) {
                helper(index + 1, ans, p, num, now + chars[i]);
            }
        }
    }
        
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
