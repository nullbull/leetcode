package study.leetcode;

import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/1/27 23:18
 * @desc
 */
public class A剑指offer52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int aL = 0;
        int bL = 0;
        while (a != null) {
            a = a.next;
            aL ++;
        }
        while (b != null) {
            b = b.next;
            bL++;
        }
        if (aL > bL) {
            int cha = aL - bL;
            while (cha > 0) {
                cha --;
                headA = headA.next;
            }
        } else if (aL < bL) {
            int cha = bL - aL;
            while (cha > 0) {
                cha --;
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
