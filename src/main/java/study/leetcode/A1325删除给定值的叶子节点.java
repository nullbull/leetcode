package study.leetcode;

import java.util.Stack;

public class A1325删除给定值的叶子节点 {


    public TreeNode removeLeafNodes(TreeNode root, int target) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode start = root;
        while (!stack.isEmpty()) {
            while (start != null) {
                stack.push(start);
                start = start.left;
            }
            start = stack.pop();
            TreeNode father = stack.peek();
            if (start.val == target && isLift(start)) {
                father.left = null;
            }
            if (father.right != null) {
                start = father.right;
            }
        }
        return root;
    }

    private boolean isLift(TreeNode node) {
        return node.left == null && node.right == null;
    }



}
