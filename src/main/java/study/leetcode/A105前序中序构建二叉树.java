package study.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author niuzhenhao
 * @date 2020/10/28 19:30
 * @desc
 */

public class A105前序中序构建二叉树 {

//    前序遍历 preorder = [3,9,20,15,7]
//    中序遍历 inorder = [9,3,15,20,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        int idx = 0;

        for (int i = 1; i < preorder.length; i++) {
            int p = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[idx]) {
                node.left = new TreeNode(p);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[idx]) {
                    node = stack.peek();
                    stack.poll();
                    ++idx;
                }
                node.right = new TreeNode(p);
                stack.push(node.right);
            }
        }


        return root;

//        TreeNode treeNode = new TreeNode();
//
//        int head = preorder[0];
//        int i = 0;
//        for (i = 0; i < inorder.length; i ++) {
//            if (inorder[i] == head) {
//                break;
//            }
//        }
//        treeNode.val = head;
//
//        int[] left = new int[i];
//        int[] right = new int[inorder.length - i];
//        System.arraycopy(preorder, 1, left, 0, i);
//        System.arraycopy(preorder, 1 + i, right,0, inorder.length - i);
//
//        return null;
    }

//    private dg(TreeNode head, ) {
//
//    }



}
