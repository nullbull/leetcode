package study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author niuzhenhao
 * @date 2021/1/27 23:05
 * @desc ac
 */
public class A515二叉树找每一行最大的 {

    public List<Integer> largestValues(TreeNode root) {




        List<Integer> res = new ArrayList<>();

        if (root == null ) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);



        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                max = Math.max(max, poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
            res.add(max);

        }
        return res;

    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{1,3,2,5,3,null,9});
        List<Integer> list = new A515二叉树找每一行最大的().largestValues(root);
    }

}
