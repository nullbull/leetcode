package study.leetcode;

import java.util.regex.Pattern;

public class A234回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        cur = head;
        int half = size / 2;
        while (half > 0) {
            cur = cur.next;
            half--;
        }
        cur =  reverseList(cur);
        half = size / 2;

        while (half > 0) {
            if (head.val != cur.val) {
                return false;
            }
            head = head.next;
            cur = cur.next;
            half--;
        }

        return true;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode last = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode root = ListNodeBulider.listNode(new int[]{1,2});
        boolean  hh = new A234回文链表().isPalindrome(root);
        System.out.println(hh);
    }
}
