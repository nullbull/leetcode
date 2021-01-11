package study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

/**
 * @author niuzhenhao
 * @date 2021/1/11 21:56
 * @desc
 */
public class A236二叉树的公共祖先 {

    List<List<Integer>> tree = new ArrayList<>();
    int pLevel = 0;
    int pPos = 0;
    int qLevel = 0;
    int qPos = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode deep = root;
//        int depth = dg(deep);
        int cur = 0;


        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>(queue.size());
            int length = queue.size();
            int size = length;
            int nullSize = 0;
            while (size > 0) {
                size--;
                TreeNode poll = queue.poll();

                if (poll != null) {
                    if (poll.val == p.val) {
                        pLevel = cur;
                        pPos = tempList.size();
                    }
                    if (poll.val == q.val) {
                        qLevel = cur;
                        qPos = tempList.size();
                    }
                    tempList.add(poll.val);
                } else {
                    nullSize++;
                    tempList.add(null);
                }

                if (nullSize < length) {
                    if(poll != null) {
                        queue.add(poll.left);
                        queue.add(poll.right);
                    } else {
                        queue.add(null);
                        queue.add(null);
                    }
                } else {
                    queue.clear();
                }
            }
            tree.add(tempList);
            cur++;
        }



        if (pLevel < qLevel) {
            while (qLevel > pLevel) {
                qPos = qPos / 2;
                qLevel--;
            }
            if (qPos == pPos) {
                return new TreeNode(tree.get(pLevel).get(pPos));
            } else {
                return getResult();
            }
        } else if (pLevel > qLevel){
            while (pLevel > qLevel) {
                pPos = pPos / 2;
                pLevel--;
            }
            if (qPos == pPos) {
                return new TreeNode(tree.get(pLevel).get(pPos));
            } else {
                return getResult();
            }
        }


        return getResult();

    }

    private TreeNode getResult() {
        if (pLevel == qLevel) {
            while (pLevel > 0) {
                pPos = pPos / 2;
                qPos = qPos / 2;
                if (pPos == qPos) {
                    return new TreeNode(tree.get(--pLevel).get(pPos));
                }
                pLevel--;
                qLevel--;
            }
        }
        return null;
    }
//    private int dg(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        int depth = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size > 0) {
//                TreeNode poll = queue.poll();
//                if (poll.left != null) {
//                    queue.add(poll.left);
//                }
//                if (poll.right != null) {
//                    queue.add(poll.right);
//                }
//                size--;
//            }
//            depth++;
//        }
//        return depth;
//    }


    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeBulider.treeNode(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode treeNode = TreeNodeBulider.treeNode(new Integer[]{1,2});
        TreeNode res = new A236二叉树的公共祖先().lowestCommonAncestor(treeNode, new TreeNode(1), new TreeNode(2));
        System.out.println(res);

        System.out.println(1 << 2);
        System.out.println(1 << 0);
    }


}
