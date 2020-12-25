package study.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author niuzhenhao
 * @date 2020/12/25 18:02
 * @desc
 */

public class A剑指offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        dg(root);
        return root;
    }

    public void dg(TreeNode node) {
        if (node == null) {
            return ;
        }
        TreeNode temp = new TreeNode();
        temp = node.left;
        node.left = node.right;
        node.right = temp;
        dg(node.left);
        dg(node.right);
    }
}
