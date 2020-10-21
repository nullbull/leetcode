package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/10/21 14:07
 * @desc
 */

public class A100二叉树相同 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dg(p, q);
    }

    private boolean dg(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val == q.val) {
                return dg(p.left, q.left) && dg(p.right, q.right);
            }
        }
        return false;
    }
}
