package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/21 12:13
 * @desc
 */
public class A剑指offer07重建二叉树 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root =  dg(preorder, inorder);
        return root;
    }

    public TreeNode dg(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        TreeNode root = new TreeNode(pre[0]);

        int p = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == root.val) {
                p = i;
                break;
            }
        }
        int [] leftPre = new int[p];
        int [] leftIn = new int[p];
        System.arraycopy(pre, 1, leftPre, 0, p);
        System.arraycopy(in, 0, leftIn, 0, p);
        TreeNode leftNode = dg(leftPre, leftIn);
        int rightLen = pre.length-p-1;
        int[] rightPre = new int[pre.length-p-1];
        int[] rightIn = new int[pre.length-p-1];
        System.arraycopy(pre, 1 + p, rightPre, 0, rightLen);
        System.arraycopy(in, 1 + p, rightIn, 0, rightLen);
        TreeNode rightNode = dg(rightPre, rightIn);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public static void main(String[] args) {
        new A剑指offer07重建二叉树().buildTree(new int[]{3,9,20,15,7},
                new int[]{9,3,15,20,7});
    }
}
