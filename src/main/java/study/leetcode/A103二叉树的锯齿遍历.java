package study.leetcode;

import java.util.*;

/**
 * @author niuzhenhao
 * @date 2021/1/9 17:45
 * @desc
 */

public class A103二叉树的锯齿遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        int cur = 0;

        if (root == null) {
            return res;
        }

        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                level.add(queue.poll());
            }
            for (int i = 0; i < level.size(); i++) {
                TreeNode node = level.get(i);
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (cur++ % 2 == 1) {
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] integers = {3, 9, 20, null, null, 15, 7};
        Integer[] bbb = {1,2,3,4,null,null,5};
        TreeNode root = TreeNodeBulider.treeNode(integers);
        new A103二叉树的锯齿遍历().zigzagLevelOrder(root);

    }
}
