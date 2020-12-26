package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/12/26 18:57
 * @desc
 */

public class A124二叉树中路径最大和 {
    static int max = 0;
    public void test() {
        TreeNode root = new TreeNode(1);

    }
    public int dg(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 去掉这一行就ac了
        /*if (node.left == null && node.right == null) {
            return node.val;
        }*/
        int curr = node.val;
        int left = dg(node.left);
        int right = dg(node.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        max = Math.max(max, left + right + curr);
        return Math.max(curr + left, curr + right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);

        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);

        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        int dg = new A124二叉树中路径最大和().dg(root);
        System.out.println(max);

    }
}
