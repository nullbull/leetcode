package leetcode;

import java.util.Stack;

public class A32最长有效括号 {


    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        char[] chars = s.toCharArray();

        int left = -1;

        int max = 0;

        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] == '(') {
                stack.push(i);
            }

            if (chars[i] == ')' && !stack.empty()) {
                stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, i - left);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            } else if (chars[i] == ')' && stack.isEmpty()){
                left = i;
            }

        }


        return max;
    }

    public static void main(String[] args) {
        System.out.println(new A32最长有效括号().longestValidParentheses("(()()())(()()"));
    }
}
