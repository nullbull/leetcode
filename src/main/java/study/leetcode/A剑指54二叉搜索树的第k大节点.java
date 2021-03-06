package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/6 14:29
 * @desc
 */
public class A剑指54二叉搜索树的第k大节点 {
    int value = 0;
    int k = 0;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return value;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (k < 0) {
            return;
        }
//        if (root.right == null && root.left == null) {
//            k--;
//            if (k == 0) {
//                value = root.val;
//            }
//            return;
//        }

        dfs(root.right);
        k--;
        if (k == 0) {
            value = root.val;
            return;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{5,3,6,2,4,null,null,1});
        System.out.println(new A剑指54二叉搜索树的第k大节点().kthLargest(root, 3));
    }
}
