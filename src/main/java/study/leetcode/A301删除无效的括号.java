package study.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author niuzhenhao
 * @date 2021/1/5 10:55
 * @desc
 */

public class A301删除无效的括号 {
    private List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        if (s == null || s.isEmpty()) {
            res.add(s);
            return res;
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        dfs(s, 0, left, right);
        return res;
    }


    public void dfs(String s, int p, int left, int right) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                res.add(s);
                return;
            }
        }
        for (int i = p; i < s.length(); i++) {
            //减枝
            if (i != p && s.charAt(i) == s.charAt(i-1)) {
                continue;
            }
            if (s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, left - 1, right);
            } else if (s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, left, right - 1);
            }
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "()())()";
        List<String> list = new A301删除无效的括号().removeInvalidParentheses(s);
        System.out.println(list);
    }
}
