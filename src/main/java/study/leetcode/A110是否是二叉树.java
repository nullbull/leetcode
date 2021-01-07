package study.leetcode;

public class A110是否是二叉树 {


    private boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {

        dg(root);

        return isBalance;
    }

    public int dg(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.right == null && root.left  == null) {
            return 1;
        }
        int left = dg(root.left);
        int right = dg(root.right);

        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);
        root.right = a;
        a.right = c;

        System.out.println(new A110是否是二叉树().isBalanced(root));

    }


}
