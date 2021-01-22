package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/22 22:14
 * @desc ac
 */
public class A147对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        ListNode start = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode cur = start;
            while (cur.val < head.val) {
                if (cur.next != null && cur.next.val < head.val) {
                    cur = cur.next;
                } else {
                    break;
                }
            }
            ListNode a = cur.next;
            cur.next = head;
            head = head.next;
            cur.next.next = a;
        }

        return start.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);
        root.next = a;
        a.next =b;
        b.next =c;
        new A147对链表进行插入排序().insertionSortList(root);
    }

}
