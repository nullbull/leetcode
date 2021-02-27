package study.leetcode;

import java.util.Stack;

/**
 * @author niuzhenhao
 * @date 2021/2/21 18:18
 * @desc
 */
public class A剑指offer09栈实现队列 {
    static class CQueue {

        private Stack<Integer> a;
        private Stack<Integer> b;

        public CQueue() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public void appendTail(int value) {
            a.add(value);
        }

        public int deleteHead() {
            if (!b.isEmpty()) {
                return b.pop();
            } else {
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
                if (!b.isEmpty()) {
                    return b.pop();
                }
                return -1;
            }
        }
    }
}
