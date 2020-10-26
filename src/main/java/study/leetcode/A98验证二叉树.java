package study.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author niuzhenhao
 * @date 2020/10/26 9:57
 * @desc
 */

public class A98验证二叉树 {

    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        long left = Long.MIN_VALUE;
        TreeNode pre = root;
        while (!stack.isEmpty() || pre != null) {
            while(pre != null) {
                stack.push(pre);
                pre = pre.left;
            }
            pre = stack.pop();
            if (pre.val <= left) {
                return false;
            }
            left = pre.val;
            pre = pre.right;
        }

        return true;


        /*Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                TreeNode right = poll.right;
                TreeNode left = poll.left;

                if (right != null && left != null) {
                    if (right.val <= poll.val || left.val >= poll.val) {
                        return false;
                    }
                } else if (right != null) {
                    if (right.val <= poll.val) {
                        return false;
                    }
                } else if (left != null){
                    if (left.val >= poll.val) {
                        return false;
                    }
                }
                queue.add(left);
                queue.add(right);
            }

        }
        return true;*/
    }

    public static void main(String[] args) {

    }
}
