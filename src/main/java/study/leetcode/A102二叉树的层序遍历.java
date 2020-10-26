package study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author niuzhenhao
 * @date 2020/10/23 18:42
 * @desc
 */

public class A102二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();


        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            while (!queue.isEmpty()) {
                level.add(queue.poll());
            }
            List<Integer> one = new ArrayList<>();
            level.stream().forEach(a -> {
                one.add(a.val);
                if (a.left != null) {
                    queue.add(a.left);
                }
                if (a.right != null) {
                    queue.add(a.right);
                }
            });

            res.add(one);
        };
        return res;
    }
}
