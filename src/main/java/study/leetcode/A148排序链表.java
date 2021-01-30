package study.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/1/20 22:13
 * @desc
 */
public class A148排序链表 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightHead = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }

    public ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }


        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a != null) {
            cur.next = a;
        } else if (b != null) {
            cur.next = b;
        }
        return head.next;
    }

    public ListNode sortList2(ListNode head) {
        ListNode aHead = head;

        List<Integer> list = new ArrayList<>();
        while (aHead != null) {
            list.add(aHead.val);
            aHead = aHead.next;
        }
        Collections.sort(list);
        ListNode anew = new ListNode(-1);
        aHead = anew;
        for (Integer i : list) {
            ListNode listNode = new ListNode(i);
            aHead.next = listNode;
            aHead = aHead.next;
        }
        return anew.next;
    }
    
}
