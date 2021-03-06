package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/4 22:42
 * @desc
 */
public class A剑指offer35复杂链表的复制 {

    public Node copyRandomList(Node head) {

        Node aHead = head;
        while (aHead != null) {
            Node temp = new Node(aHead.val);
            Node next = aHead.next;
            aHead.next = temp;
            aHead = aHead.next;
            aHead.next = next;
            aHead = aHead.next;
        }
        aHead = head;

        while (aHead != null) {
            if (aHead.random != null) {
                aHead.next.random = aHead.random.next;
            }
            aHead = aHead.next.next;
        }

        Node res = new Node(-1);
        Node realRes = res;
        aHead = head;

        while (aHead != null) {
            res.next = aHead.next;
            res = res.next;
            if (aHead.next != null) {
                aHead.next = aHead.next.next;
            } else {
                aHead.next = null;
            }
            aHead = aHead.next;
        }

        return realRes.next;

    }

    public static void main(String[] args) {
        Node head = new Node(7);

        Node a = new Node(13);
        Node b = new Node(11);
        Node c = new Node(10);
        Node d = new Node(1);

        a.random = head;
        b.random = d;
        c.random = b;
        d.random = head;
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        new A剑指offer35复杂链表的复制().copyRandomList(head);
    }
}
