package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/28 12:15
 * @desc
 */
public class A链表相交 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;


        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
