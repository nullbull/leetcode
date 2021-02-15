package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/14 18:42
 * @desc
 */
public class A求根到叶子节点数字之和 {
    int res = 0;

    public int sumNumbers(TreeNode root) {

        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode root, String cur) {
        if (root == null) {
            return;
        }
        if (root.left == null&& root.right == null) {
            cur += root.val;
            res += Integer.parseInt(cur);
            return;
        }
        String temp = new String(cur);
        cur += root.val;
        int l = cur.length();
        dfs(root.left, cur);
        cur = cur.substring(0, l);
        dfs(root.right, cur);
        cur = temp;

    }

    public static void main(String[] args) {
        System.out.println(new A求根到叶子节点数字之和().sumNumbers(TreeNodeBulider.treeNode(new Integer[]{1,2,3})));
        System.out.println(new A求根到叶子节点数字之和().sumNumbers(TreeNodeBulider.treeNode(new Integer[]{4, 9, 0, 5, 1})));
    }




}
