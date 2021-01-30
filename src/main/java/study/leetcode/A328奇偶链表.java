package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/28 17:55
 * @desc
 */

public class A328奇偶链表 {


    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return head;
        }


        int cur = 1;
        ListNode l =  head;
        ListNode a = new ListNode(-1);
        ListNode aa = a;
        ListNode b = new ListNode(-1);
        ListNode bb = b;
        while (l != null) {
            ListNode next = l.next;
            if (cur % 2 == 1) {
                a.next = l;
                a = a.next;
            } else {
                b.next = l;
                b = b.next;
            }
            l.next = null;
            cur++;
            l = next;
        }
        a.next = bb.next;
        return aa.next;
    }



}
