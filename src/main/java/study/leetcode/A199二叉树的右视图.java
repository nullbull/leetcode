package study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author niuzhenhao
 * @date 2021/1/12 21:50
 * @desc ac
 */
public class A199二叉树的右视图 {



    public List<Integer> rightSideView(TreeNode root) {


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode poll = queue.poll();

                if (size == 0) {
                    res.add(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }
}
