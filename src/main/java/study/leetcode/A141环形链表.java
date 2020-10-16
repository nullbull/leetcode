package study.leetcode;

import java.util.HashSet;

/**
 * @author niuzhenhao
 * @date 2020/10/15 10:03
 * @desc
 */

public class A141环形链表 {


    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        System.out.println(new A141环形链表().hasCycle(a));

    }

}
