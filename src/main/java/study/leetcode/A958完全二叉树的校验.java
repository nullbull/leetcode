package study.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

/**
 * @author niuzhenhao
 * @date 2021/2/12 23:39
 * @desc
 */
public class A958完全二叉树的校验 {

    boolean res = true;
//    public boolean isCompleteTree(TreeNode root) {
//        dg(root);
//        return res;
//    }
//
//    public int dg(TreeNode root) {
//        if (root == null ) {
//            return 0;
//        }
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//        int left = dg(root.left);
//        int right = dg(root.right);
//        if (right == 1 && left == 0) {
//            res = false;
//        } else if (right >= left &&  right > 1 && right % 2 == 0) {
//            res = false;
//        }
//        return left + right + 1;
//    }
public boolean isCompleteTree(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean res = false;
    while (!queue.isEmpty()) {
        TreeNode poll = queue.poll();
        if (!res && poll == null) {
            res = true;
            continue;
        }
        if (res) {
            if (poll != null) {
                return false;
            }
            continue;
        }
        queue.add(poll.left);
        queue.add(poll.right);
    }

    return true;

}


}
