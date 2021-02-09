package study.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author niuzhenhao
 * @date 2021/1/30 18:22
 * @desc
 */
public class A402移掉K位数字 {


    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            if (k == 0 || stack.isEmpty()) {
                stack.push(chars[i]);
            } else if (k > 0){
                if (stack.peek() >= chars[i]) {
                    while (!stack.isEmpty() && k > 0) {
                        if (stack.peek() > chars[i]) {
                            stack.pollFirst();
                            k--;
                        } else {
                            break;
                        }
                    }
                    stack.push(chars[i]);
                } else {
                    k--;
                }
            }

        }
        if (k > 0) {
            while (k > 0) {
                stack.pollFirst();
                k--;
            }
        }

        while (!stack.isEmpty() && stack.peekLast() == '0') {
            stack.pollLast();
        }
        String res = "";
        while (!stack.isEmpty() ) {
            res += stack.pollLast();
        }
        if (res.length() == 0) {
            return "0";
        }
        return res;
    }

    public String removeKdigits2(String num, int k) {
        int n = num.length();
        if (n == k) {
            return "0";
        }
        while (k > 0) {
            if (num.length() >= 2) {
                if (num.charAt(0) < num.charAt(1)) {
                    num = num.substring(0, 1) + num.substring(2);
                } else if (num.charAt(0) > num.charAt(1)){
                    num = num.substring(1);
                } else {
                    if (num.charAt(0) <= num.charAt(num.length()-1)) {
                        num = num.substring(0, num.length()-1);
                    }
                }
            } else {
                num = num.substring(0, 1);
            }
            k--;
        }
        while (num.length() >1 && num.charAt(0) == '0') {
            num = num.substring(1);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new A402移掉K位数字().removeKdigits("1432219", 3));
        System.out.println(new A402移掉K位数字().removeKdigits("10200", 1));
        System.out.println(new A402移掉K位数字().removeKdigits("10", 1));
        System.out.println(new A402移掉K位数字().removeKdigits("112", 1));
        System.out.println(new A402移掉K位数字().removeKdigits("191", 1));
        System.out.println(new A402移掉K位数字().removeKdigits("9", 1));
        System.out.println(new A402移掉K位数字().removeKdigits("100", 3));

    }

}
