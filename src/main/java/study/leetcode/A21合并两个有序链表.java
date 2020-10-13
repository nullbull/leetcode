package study.leetcode;

/**
 * ac
 */
public class A21合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);

        ListNode now = res;

        while (l1 != null && l2 != null) {
            while ( l1 != null && l1.val <= l2.val) {
                now.next = l1;
                l1 = l1.next;
                now = now.next;
            }
            if (l1 == null) {
                break;
            }

            while ( l2 != null && l2.val <= l1.val) {
                now.next = l2;
                l2 = l2.next;
                now = now.next;
            }
        }

        if (l1 != null) {
            now.next = l1;
        }
        if (l2 != null) {
            now.next = l2;
        }


        return res.next;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);


        ListNode d = new ListNode(3);
        ListNode f = new ListNode(4);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;

        e.next = d;
        d.next = f;
        new A21合并两个有序链表().mergeTwoLists(a,  e);
    }
}
