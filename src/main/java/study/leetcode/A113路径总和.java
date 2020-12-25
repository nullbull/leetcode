package study.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author niuzhenhao
 * @date 2020/12/25 10:03
 * @desc
 */

public class A113路径总和 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dg(result, new ArrayList<>(), sum, root);
        return result;
    }

    public void dg(List<List<Integer>> result, ArrayList<Integer> once, int sum, TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(once);
        once.add(node.val);
        if (node.left == null && node.right == null) {
            Integer integer = once.stream().reduce(Integer::sum).get();
            if (integer == sum) {
                result.add(new ArrayList<>(once));
                once.remove(once.size() - 1);
                return;
            }

        }
        dg(result, once, sum, node.left);
        dg(result, once, sum, node.right);
        once.remove(once.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(4);
        TreeNode c = new TreeNode(11);
        TreeNode d = new TreeNode(7);
        TreeNode e = new TreeNode(2);

        TreeNode f = new TreeNode(8);
        TreeNode g = new TreeNode(13);
        TreeNode h = new TreeNode(4);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);


        root.left = a;
        root.right = f;
        a.left = c;
        c.left = d;
        c.right = e;

        f.left = g;
        f.right = h;
        h.left = i;
        h.right = j;

        List<List<Integer>> lists = new A113路径总和().pathSum(root, 22);
        System.out.println(lists);

    }


//
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        List<List<Integer>> result = new ArrayList<>();
//        dg(stack, result, new ArrayList<>(), sum, root);
//        return result;
//    }
//
//    public void dg(Stack<TreeNode> stack, List<List<Integer>> result, ArrayList<Integer> once, int sum, TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        once.add(node.val);
//        if (node.right == null || node.left == null) {
//            Integer integer = once.stream().reduce(Integer::sum).get();
//            if (integer == sum) {
//                result.add(new ArrayList<>(once));
//            } else {
//                once.remove(once.size()-1);
//                node = stack.pop();
//                dg(stack, result, once, sum, node.right);
//            }
//        }
//        stack.add(node);
//        if (node.left != null) {
//            dg(stack, result, once, sum, node.left);
//        } else if (node.right != null){
//            dg(stack, result, once, sum, node.right);
//        }
//
//    }
}
