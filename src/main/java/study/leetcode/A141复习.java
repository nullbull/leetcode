package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/13 21:35
 * @desc
 */
public class A141复习 {


    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while (slow != quick) {
            if (slow == null) {
                return false;
            }
            slow = slow.next;
            if (quick != null && quick.next != null) {
                quick =  quick.next.next;
            } else {
                quick = null;
            }
        }
        return slow !=  null;
    }



}
