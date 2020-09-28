package study.leetcode;

public class A23合并K个排序链表 {


    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwo(lists[i - 1], lists[i]);
        }

        return lists[lists.length - 1];
    }

    public static ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode temp = new ListNode(0);

        ListNode rt = temp;


        while (a != null && b != null) {
            if (a.val > b.val) {
                temp.next = b;
                b = b.next;
            } else {
                temp.next = a;
                a = a.next;
            }
            temp = temp.next;
        }

        if (a != null) {
            temp.next = a;
        }
        if (b != null) {
            temp.next = b;
        }

        return rt.next;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(5);

        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);

        ListNode g = new ListNode(2);
        ListNode h = new ListNode(6);

        a.next = b;
        b.next = c;

        d.next = e;
        e.next = f;

        g.next = h;

        mergeKLists(new ListNode[]{a, d, g});


    }
}
