package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/2 18:57
 * @desc
 */

public class A142环形链表2 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode newHead = head;

        int l = 0;
        boolean isCycle = false;
        while (slow != null && fast.next != null) {
            l++;
            if (slow == fast) {
                isCycle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (isCycle) {
            while (head != newHead) {
                head = head.next;
                newHead = newHead;
            }
            return newHead;
        }
        return null;

    }


}
