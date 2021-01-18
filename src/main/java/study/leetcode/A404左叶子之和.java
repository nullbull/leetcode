package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/18 22:46
 * @desc ac
 */
public class A404左叶子之和 {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dg(root, false);
        return sum;
    }


    public void dg(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeft) {
            sum += root.val;
        }
        dg(root.left, true);
        dg(root.right, false);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{3,9,20,null,null,15,7});
        new A404左叶子之和().sumOfLeftLeaves(root);
    }




}
