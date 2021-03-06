package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/6 12:11
 * @desc
 */
public class A剑指Offer55I二叉树的深度 {

    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            max = Math.max(depth + 1, max);
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

}
