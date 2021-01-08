package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/1/8 19:16
 * @desc ac
 */

public class A86分割链表 {

    public ListNode partition(ListNode head, int x) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        int idx = 0;
        int tp = 0;
        boolean find = false;
        List<Integer> pos = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            if (!find && cur.val >= x) {
                tp = idx;
                find = true;
            }
            if (cur.val < x && find) {
                pos.add(idx);
            }
            idx++;
            cur = cur.next;
        }
        int n = list.size();
        ListNode a = new ListNode(-1);
        head = a;
        for (int i = 0; i < tp; i++ ) {
            a.next = new ListNode(list.get(i));
            a = a.next;
        }
        for (int i = 0; i < pos.size(); i++) {
            a.next = new ListNode(list.get(pos.get(i)));
            a = a.next;
        }
        for (int i = tp; i < n; i++) {
            if (!pos.contains(i)) {
                a.next = new ListNode(list.get(i));
                a = a.next;
            }
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(2);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        new A86分割链表().partition(head, 3);
    }
}
