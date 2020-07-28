package leetcode;

public class A交换链表 {
    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode en = new ListNode(-1);

        ListNode go = new ListNode(-2);
        go.next = head;
        ListNode before = null;

        boolean first = true;
        while (go.next != null && go.next.next != null) {
            ListNode temp = null;
            ListNode second = go.next.next;
            temp = second.next;
            second.next = go.next;
            second.next.next = null;
            //如果后面还有
            if (temp != null && temp.next != null) {
                go.next = temp;
             //后面只有一个了
            } else {
                second.next.next = temp;
                go.next = null;
                if (before != null) {
                    before.next = second;
                    break;
                }
            }
            if (first) {
                en.next = second;
                first = false;
            } else {
                before.next = second;
            }
            before = second.next;
        }
        go = null;
        return en.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode f = new ListNode(5);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = f;
        System.out.println(swapPairs(a));
    }
}