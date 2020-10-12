package study.leetcode;

import jdk.nashorn.internal.ir.ThrowNode;

import java.util.*;

/**
 * @author niuzhenhao
 * @date 2020/10/10 9:51
 * @desc
 */

public class A94二叉树的中序遍历 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public List<Integer> inorderTraversal2(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            res.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }

        }

        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode t = root;
        while (!stack.isEmpty() || t != null) {
            if (t != null) {
                stack.push(t);
                t = t.left;
            } else {
                t = stack.pop();
                res.add(t.val);
                t = t.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = null;
        TreeNode second = new TreeNode();
        second.val = 2;

        TreeNode third = new TreeNode();
        third.val = 3;
        root.right = second;
        second.left = third;
        new A94二叉树的中序遍历().inorderTraversal(root);

    }
}
