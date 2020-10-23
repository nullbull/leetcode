package study.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author niuzhenhao
 * @date 2020/10/23 10:04
 * @desc
 */

public class A155最小栈 {

    static class MinStack {

        private Stack<Integer> stack;
        private List<Integer> list;
        private int min;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            list = new ArrayList<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {

            min = Math.min(x, min);
            stack.push(x);
            list.add(x);

        }

        public void pop() {
            stack.pop();
            if (!list.isEmpty()) {
                list.remove(list.size() -1);
                if (!list.isEmpty()) {
                    min = list.stream().min(Integer::compareTo).get();
                } else {
                    min = Integer.MAX_VALUE;
                }
            }

        }

        public int top() {
           return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        minStack.getMin();
        minStack.push(-2147483648);
        minStack.top();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();

    }
}
