package study.leetcode;

public class A19删除链表的倒数第N个节点 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode p = new ListNode(0);
        p.next = head;
        ListNode start = p;
        ListNode end = p;
        while (p.next != null) {
            p = p.next;
            if (n > 0) {
                n--;
            } else {
                end = end.next;
            }
        }

        if (end.next == null) {
            return start.next;
        }
        end.next = end.next.next;

        return start.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = null;
        System.out.println(removeNthFromEnd(listNode, 1));
    }
}
