package study.leetcode;

import java.util.*;

/**
 * @author niuzhenhao
 * @date 2021/2/16 18:47
 * @desc
 */
public class A22括号生成复习 {
    Set<String> res = new HashSet<>();

    public List<String> generateParenthesis(int n) {

        dg2(n * 2, "", 0, 0);
        return new ArrayList<>(res);
    }
    public void dg(int n, String cur, int p) {
        if (cur.length() == n && isValid(cur)) {
            res.add(new String(cur));
        }
        for (int i = p; i < n; i++) {
            cur += "(";
            dg(n, cur, p + 1);
            cur = cur.substring(0, cur.length()-1);
            cur += ")";
            dg(n, cur, p + 1);
            cur = cur.substring(0, cur.length()-1);
        }
    }

    public boolean isValid(String s) {
        Stack<Character>  stack = new Stack<>();
        char[] cc = s.toCharArray();
        for (char c : cc) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public void dg2(int n , String cur, int left, int right) {
        if (cur.length() == n) {
            res.add(new String(cur));
        }
        if (left < n / 2) {
            cur += "(";
            dg2(n, cur, left + 1, right);
            cur = cur.substring(0, cur.length()-1);
        }
        if (right < left){
            cur += ")";
            dg2(n, cur, left , right + 1);
            cur = cur.substring(0, cur.length()-1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new A22括号生成复习().generateParenthesis(3));
    }
}
