package study.leetcode;

import java.util.List;

/**
 * ac  2021-01-09
 */

public class A206反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode last = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode root = ListNodeBulider.listNode(new int[]{1, 2 , 3 ,4, 5});
        new A206反转链表().reverseList(root);
    }
}
