package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/6 12:15
 * @desc
 */
public class A剑指Offer28对称的二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode root, TreeNode compare) {

        if (root == null && compare == null) {
            return true;
        } else if (root != null && compare != null) {
            if (root.val == compare.val) {
                return dfs(root.left, compare.right) && dfs(root.right, compare.left);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
