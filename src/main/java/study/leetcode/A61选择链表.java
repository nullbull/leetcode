package study.leetcode;

import java.util.Stack;

/**
 * @author niuzhenhao
 * @date 2020/9/16 9:47
 * @desc
 */

/**
 * AC
 */
public class A61选择链表 {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        int length = 0;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            length++;
            stack.push(temp);
            temp = temp.next;
        }
        k = k % length;
        for (int i = 0; i < k; i++) {
            ListNode pop = stack.pop();
            pop.next = head;
            head = pop;
        }
        ListNode temp2 = head;
        while (length > 1 ) {
            temp2 = temp2.next;
            length--;
        }
        temp2.next = null;
        return head;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        new A61选择链表().rotateRight(a, 2);

    }

}
