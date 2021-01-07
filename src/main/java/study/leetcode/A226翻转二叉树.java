package study.leetcode;

public class A226翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        dg(root);
        return root;
    }

    private void dg(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        dg(root.left);
        dg(root.right);
        root.left = root.right;
        root.right = temp;
    }



}
