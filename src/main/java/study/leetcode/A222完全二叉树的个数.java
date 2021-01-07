package study.leetcode;

public class A222完全二叉树的个数 {


    public int countNodes(TreeNode root) {

        return dg(root);
    }


    public int dg(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        int left = dg(root.left);
        int right = dg(root.right);
        return left + right + 1;
    }

}
