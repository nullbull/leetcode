package study.datastruct;

import java.util.Stack;

/**
 * @author niuzhenhao
 * @date 2020/12/17 17:18
 * @desc
 */

public class A表达式求值 {

    public static void main(String[] args) {
        String sz = "3*5-(6+8)/2";
//        String sz = "1+(2*3)";
        Stack<Character> nums = new Stack<>();
        Stack<Character> operate = new Stack<>();
        char[] cs = sz.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];

            if (c >= '0' && c <= '9') {
                nums.push(c);
            } else {
                if (operate.empty()) {
                    operate.push(c);
                }
                else if (c == '(') {
                    operate.push(c);
                } else if (c == ')') {
                    while (operate.peek() != '(') {
                        nums.push(operate.pop());
                    }
                    operate.pop();
                }
                else if (operate.peek() == '/' || operate.peek() == '*') {
                    if (c == '+' || c == '-') {
                        nums.push(operate.pop());
                        operate.push(c);
                    } else {
                        operate.push(c);
                    }
                } else {
                    operate.push(c);
                }
            }
        }
        while (!operate.empty()) {
            nums.push(operate.pop());
        }
        Stack<Integer> hha = new Stack<>();
        Stack<Character> cha = new Stack<>();
        while (!nums.isEmpty()) {
            cha.push(nums.pop());
        }
        while (!cha.isEmpty()) {
            Character pop = cha.pop();
            if (pop >= '0' && pop <= '9') {
                hha.push(pop - '0');
            } else {
                int first = hha.pop();
                int second = hha.pop();
                int result = 0;
                switch (pop) {
                    case '+':
                        result = first + second;
                        break;
                    case '-' :
                        result = second - first;
                        break;
                    case '*':
                        result = first * second;
                        break;
                    case '/':
                        result = second / first;
                        break;
                }
                hha.push(result);
            }
        }
        System.out.println(hha.pop());
    }
}
