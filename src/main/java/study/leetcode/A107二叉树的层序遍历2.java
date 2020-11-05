package study.leetcode;

import java.util.*;

/**
 * @author niuzhenhao
 * @date 2020/11/5 19:00
 * @desc
 */

public class A107二叉树的层序遍历2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(res);
        return res;
    }
}
