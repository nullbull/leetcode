package study.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author niuzhenhao
 * @date 2020/12/26 10:00
 * @desc ac
 */

public class A257二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dg(root, result, new ArrayList<Integer>());
        result.forEach(a -> {
            String collect = a.stream().map(Object::toString).collect(Collectors.joining("->"));
            res.add(collect);
        });
        return res;
    }

    public void dg(TreeNode node, List<List<Integer>> res, List<Integer> curr) {
        if (node == null) {
            return;
        }
        curr.add(node.val);
        if (node.left == null && node.right == null) {
            res.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        dg(node.left, res, curr);
        dg(node.right, res, curr);
        curr.remove(curr.size() - 1);
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
        List<String> list = new A257二叉树的所有路径().binaryTreePaths(root);
        System.out.println(list);
    }
}
