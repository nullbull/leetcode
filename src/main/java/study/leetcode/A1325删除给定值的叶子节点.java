package study.leetcode;

import java.util.Stack;

public class A1325删除给定值的叶子节点 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        root = dfs(root, target);

        return root;
    }

    public TreeNode dfs(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
//        if (root.left == null && root.right == null && root.val == target) {
//            return null;
//        }

        root.left = dfs(root.left, target);
        root.right = dfs(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }


    public TreeNode removeLeafNodes2(TreeNode root, int target) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean isLeft =  true;
        TreeNode father = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
                isLeft = true;
            }
            if(!stack.isEmpty()) {
                cur = stack.pop();
                if (cur.val == target && isLift(cur)) {
                    if (!stack.isEmpty()) {
                        if (isLeft) {
                            stack.peek().left = null;
                        } else {
                            stack.peek().right = null;
                        }
                    } else {
                        if (isLeft) {
                            father.left = null;
                        } else {
                            father.right = null;
                        }
                    }
                }
                cur = cur.right;
                isLeft = false;
            }
//            TreeNode father = stack.peek();
//            if (cur.val == target && isLift(cur)) {
//                if (isLeft) {
//                    father.left = null;
//                } else {
//                    father.right = null;
//                }
//
//            }
//            if (father.right != null) {
//                cur = father.right;
//                isLeft = false;
//            } else {
//                cur = null;
//            }
        }
        return root;
    }

    private boolean isLift(TreeNode node) {
        return node.left == null && node.right == null;
    }




    public static void main(String[] args) {
//        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{1,2,3,2,null,2,4});
        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{1,3, 2, 2, null, null ,3});
        new A1325删除给定值的叶子节点().removeLeafNodes(root, 3);
    }

}
