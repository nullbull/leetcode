package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/14 19:08
 * @desc
 */
public class A112路径总和 {

    private boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        dg(root, targetSum);

        return res;
    }

    public void dg(TreeNode root, int cur) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            cur -= root.val;
            if (cur == 0) {
                res = true;
            }
            return;
        }
        cur -= root.val;
        int temp = cur;
        dg(root.left, cur);
        dg(root.right, temp);
    }
}
