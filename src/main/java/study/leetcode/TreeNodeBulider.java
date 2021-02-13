package study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author niuzhenhao
 * @date 2021/1/8 10:16
 * @desc 根据数组构建 二叉平衡树
 */

public class TreeNodeBulider {

    public  static TreeNode treeNode(Integer[] nums) {
        int cur = 2;
        int sum = 1;
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == null) {
                list.add(null);
            } else {
                list.add(new TreeNode(nums[i]));
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(list.get(0));
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            for (int i = sum; i < cur + sum && i < nums.length && !queue.isEmpty(); i += 2) {
                TreeNode father = queue.poll();
                if (father == null) {
                    continue;
                }
                if (i < list.size()) {
                    father.left = list.get(i);
                    temp.add(list.get(i));
                }
                if (i + 1 < list.size()) {
                    father.right = list.get(i+1);
                    temp.add(list.get(i+1));
                }
            }
            queue.addAll(temp);
            sum += cur;
            cur = cur * 2;
            if (sum > nums.length) {
                break;
            }
        }

        return list.get(0);

    }

    public static void main(String[] args) {
        TreeNode node = treeNode(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(node);
    }


}
