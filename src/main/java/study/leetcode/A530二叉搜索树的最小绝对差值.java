package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/2/28 11:43
 * @desc
 */
public class A530二叉搜索树的最小绝对差值 {
        List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        dg(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i-1));
        }
        return min;
    }
    private void dg(TreeNode root) {
        if (root == null) {
            return;
        }
        dg(root.left);
        list.add(root.val);
        dg(root.right);
    }
}
