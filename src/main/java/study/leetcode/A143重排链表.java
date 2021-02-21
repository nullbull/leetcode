package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/15 17:35
 * @desc
 */
public class A143重排链表 {


    public void reorderList(ListNode head) {
        ListNode res = head;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revert = null;
        while (slow != null) {
            ListNode temp = slow;
            slow = slow.next;
            temp.next = revert;
            revert = temp;
        }

        ListNode realRes = new ListNode(-1);
        head = realRes;
        while (res != null && revert != null) {
            ListNode tempA = res;
            ListNode tempB = revert;
            res = res.next;
            revert = revert.next;
            realRes.next = tempA;
            realRes = realRes.next;
            realRes.next = tempB;
            realRes = realRes.next;
        }
        realRes.next = null;

        head = head.next;

    }

    public static void main(String[] args) {
        new A143重排链表().reorderList(ListNodeBulider.listNode(new int[]{1,2,3,4,5}));
    }




}
