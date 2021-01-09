package study.leetcode;

public class ListNodeBulider {

    public static ListNode listNode(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode ahead = head;
        for (int i = 0; i < nums.length;i++) {
            ListNode temp = new ListNode(nums[i]);
            head.next = temp;
            head = temp;
        }
        return ahead.next;
    }


}
