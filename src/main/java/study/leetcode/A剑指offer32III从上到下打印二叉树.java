package study.leetcode;

import java.util.*;

/**
 * @author niuzhenhao
 * @date 2021/3/6 12:30
 * @desc
 */
public class A剑指offer32III从上到下打印二叉树 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        int cur = 0;
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (cur % 2 == 0) {
                res.add(list);
            } else {
                Collections.reverse(list);
                res.add(list);
            }
            cur++;
        }
        return res;

    }
}
