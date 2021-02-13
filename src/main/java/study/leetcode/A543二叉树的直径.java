package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/13 22:50
 * @desc
 */
public class A543二叉树的直径 {


    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dg(root);
        return max;
    }

    public int dg(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null  && root.right == null ) {
            return 1;
        }
        int left = dg(root.left);
        int right = dg(root.right);

        if (left != 0 && right != 0) {
            max = Math.max(max, left + right);
        }else  if (left == 0) {
            max = Math.max(max, right);
        } else if (right == 0) {
            max = Math.max(max, left);
        }
        return Math.max(left, right)  + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{2,3,null,1});
        System.out.println(new A543二叉树的直径().diameterOfBinaryTree(root));
    }
}
