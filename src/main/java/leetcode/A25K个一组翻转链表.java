package leetcode;

/**
 * @author niuzhenhao
 * @date 2020/7/28 17:54
 * @desc
 */

public class A25K个一组翻转链表 {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }


        ListNode go = new ListNode(-2);
        ListNode re = new ListNode(-1);
        re.next = head;
        go = re;

        while (go != null && go.next != null) {
            int count = 0;
            ListNode[] list = new ListNode[k];
            ListNode start = go;
            while (count < k) {
                if (go.next != null) {
                    list[count++] = go.next;
                    go = go.next;
                } else {
                    break;
                }
            }
            ListNode temp = go.next;
            if (count < k) {
                break;
            }
            for (int i = k - 1; i >= 0; i--) {
                if (i >= 1) {
                  list[i].next = list[i - 1];
                }
            }
            list[0].next = temp;
            go = list[0];
            start.next = list[k - 1];
        }
        return re.next;
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
        System.out.println(reverseKGroup(a, 2));
    }


}
