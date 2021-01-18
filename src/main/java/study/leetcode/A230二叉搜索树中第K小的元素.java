package study.leetcode;

import jdk.nashorn.internal.ir.ThrowNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/1/18 22:04
 * @desc ac
 */
public class A230二叉搜索树中第K小的元素 {


    private List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dg(root);
        return list.get(k-1);
    }
    public void dg(TreeNode root) {
        if (root == null ) {
            return;
        }
        if (root.right == null && root.left == null) {
            list.add(root.val);
            return;
        }
        dg(root.left);
        list.add(root.val);
        dg(root.right);
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{5,3,6,2,4,null,null,1});
        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{3,1,4,null,2});
        System.out.println(new A230二叉搜索树中第K小的元素().kthSmallest(root, 1));
    }

}
