package study.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author niuzhenhao
 * @date 2020/10/19 10:00
 * @desc
 */

public class A101二叉树对称 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return digui(root, root);
    }

    private boolean digui(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            if (left.val == right.val) {
                return digui(left.left, right.right) && digui(left.right, right.left);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode();



    }
}
