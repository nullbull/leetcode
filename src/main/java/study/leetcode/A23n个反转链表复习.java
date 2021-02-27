package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/25 10:23
 * @desc
 */

public class A23n个反转链表复习 {
    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode aHead = head;
        int length = 0;
        while (aHead != null) {
            aHead = aHead.next;
            length++;
        }
        if (length < k) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode realHead = newHead;
        newHead.next = head;
        aHead = head;
        while (length > 0) {
            int cur = k;
            ListNode temp = null;
            if (length >= k) {
                while (length > 0 && cur > 0) {
                    ListNode next = aHead.next;
                    aHead.next = temp;
                    temp = aHead;
                    aHead = next;
                    length--;
                    cur--;
                }
                realHead.next = temp;
                while (temp != null && temp.next != null) {
                    temp = temp.next;
                }
                temp.next = aHead;
                realHead = temp;
            } else {
                realHead.next = aHead;
                length = 0;
            }

        }
        return newHead.next;
    }
}
