package study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author niuzhenhao
 * @date 2020/10/28 19:05
 * @desc
 */

public class A104二叉树的深度 {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            List<TreeNode> level = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    level.add(poll.left);
                }
                if (poll.right != null) {
                    level.add(poll.right);
                }
            }
            queue.addAll(level);
        }

        return count;
    }


}
