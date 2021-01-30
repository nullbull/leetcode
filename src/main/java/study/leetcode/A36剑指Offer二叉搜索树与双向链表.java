package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/30 18:01
 * @desc
 */
public class A36剑指Offer二叉搜索树与双向链表 {

    Node head;
    Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        dg(root);
        head.left = pre;
        pre.right = head;
        return head;

    }
    public void dg(Node root) {
        if (root == null) {
            return;
        }
        dg(root.left);
        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        dg(root.right);
    }


}
