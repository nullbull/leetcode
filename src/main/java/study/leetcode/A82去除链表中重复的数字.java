package study.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2020/12/31 14:53
 * @desc 基本上ac 提交了两次
 */

public class A82去除链表中重复的数字 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head ==null) {
            return head;
        }

        ListNode start = new ListNode(-1);
        ListNode p = start;
        while (head != null) {
            ListNode temp = head;
            int count = 0;
            while (temp.next != null && temp.next.val == temp.val) {
                temp = temp.next;
                count++;
            }
            if (count > 0) {
                temp = temp.next;
                head = temp;
            } else {
                start.next = new ListNode(head.val);
                start = start.next;
                head = temp.next;
            }
        }
        return p.next;
    }

    public static void main(String[] args) {
        ListNode start = new ListNode(-1);
        ListNode head = start;
        List<Integer> list = Arrays.asList(1,2, 2);
        for (Integer a : list) {
            ListNode temp = new ListNode(a);
            start.next = temp;
            start = start.next;
        }
        new A82去除链表中重复的数字().deleteDuplicates(head.next);
    }
}

