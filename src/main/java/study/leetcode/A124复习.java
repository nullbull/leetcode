package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/13 21:04
 * @desc
 */
public class A124复习 {


    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        dg(root);
        return max;

    }

    public int dg(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = Math.max(root.val, max);
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int left = dg(root.left);
        int right = dg(root.right);
        int val = root.val;
        if (val >= 0) {
            max = Math.max(left + val, max);
            max = Math.max(right + val, max);
            max = Math.max(right + left + val, max);
        } else {
            if (root.left != null) {
                max = Math.max(left, max);
            }
            if (root.right != null ) {
                max = Math.max(right, max );
            }

        }

        return Math.max(left + val, right + val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{-2, -1});
//        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});


        int i = new A124复习().maxPathSum(root);
        System.out.println(i);
    }
}
