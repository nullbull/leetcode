package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/10 22:28
 * @desc ac
 */
public class A105前序和中序构建二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null) {
            return null;
        }

        TreeNode root = dg(preorder, inorder);
        return root;
    }

    public TreeNode dg(int [] preorder, int[] inorder) {

        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        int root = preorder[0];
        int leftSize = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root == inorder[i]) {
                break;
            }
            leftSize ++;
        }


        int[] leftTreePre = new int[leftSize];
        int[] leftTreeIn = new int[leftSize];
        System.arraycopy(preorder, 1, leftTreePre, 0, leftSize );
        System.arraycopy(inorder, 0, leftTreeIn, 0, leftSize);
        int rightSize = preorder.length-1-leftSize;
        int[] rightTreePre = new int[rightSize];
        int[] rightTreeIn = new int[rightSize];

        System.arraycopy(preorder, 1 + leftSize, rightTreePre, 0, rightSize );
        System.arraycopy(inorder, leftSize + 1, rightTreeIn, 0, rightSize);


        TreeNode left = dg(leftTreePre, leftTreeIn);
        TreeNode right = dg(rightTreePre, rightTreeIn);
        TreeNode rootTree = new TreeNode(root);
        rootTree.right = right;
        rootTree.left = left;
        return rootTree;
    }

    public static void main(String[] args) {
        new A105前序和中序构建二叉树().buildTree(new int[]{3, 9 ,20 , 15, 7}, new int[]{9, 3, 15, 20, 7 });
    }
}
