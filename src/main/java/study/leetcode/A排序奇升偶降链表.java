package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/15 16:13
 * @desc
 */
public class A排序奇升偶降链表 {
    public ListNode sort(ListNode head) {
        ListNode a = new ListNode(-1);
        ListNode aa = a;
        ListNode b = new ListNode(-1);
        ListNode bb = b;
        int cur = 1;
        while (head != null) {
            if (cur++ % 2 == 1) {
                aa.next = head;
                aa = aa.next;
            } else {
                bb.next = head;
                bb = bb.next;
            }
            head = head.next;
            if (head == null) {
                aa = null;
            }
        }
        ListNode bbb = b.next;
        ListNode bHead = null;
        while (bbb != null) {
            ListNode temp = bbb;
            bbb = bbb.next;
            temp.next = bHead;
            bHead = temp;
        }
        ListNode res = new ListNode(-1);
        ListNode r = res;
        a = a.next;
        while (bHead != null && a != null) {
            ListNode tempA = a;
            ListNode tempB = bHead;
            a = a.next;
            bHead = bHead.next;
            r.next = tempA;
            r = r.next;
            r.next = tempB;
            r = r.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeBulider.listNode(new int[]{1, 8, 3, 6, 5, 4, 7, 2});
        new A排序奇升偶降链表().sort(listNode);

    }
}
