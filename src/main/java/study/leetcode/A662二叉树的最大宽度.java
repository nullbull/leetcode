package study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author niuzhenhao
 * @date 2021/2/13 21:33
 * @desc
 */
public class A662二叉树的最大宽度 {

//    public int widthOfBinaryTree(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int max = -1;
//        while (!queue.isEmpty()) {
//            List<TreeNode> list = new ArrayList<>();
//            int nullSize = 0;
//            while (!queue.isEmpty()) {
//                TreeNode poll = queue.poll();
//                if(poll != null) {
//                    if (poll.right != null) {
//                        list.add(poll.left);
//                        list.add(poll.right);
//                    } else if (poll.left != null){
//                        list.add(poll.left);
//                        list.add(null);
//                    } else {
//                        list.add(null);
//                        list.add(null);
//                        nullSize += 2;
//                    }
//                } else {
//                    nullSize += 2;
//                    list.add(null);
//                    list.add(null);
//                }
//            }
//            if (nullSize < list.size()) {
//                int pos = 0;
//                for (int i = list.size() -1; i>=0; i--) {
//                    if (list.get(i) != null) {
//                        pos = i;
//                        break;
//                    }
//                }
//
//                max = Math.max(pos + 1, max);
//                queue.addAll(list);
//            }
//        }
//        return max;
//    }



    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> indexList = new LinkedList<>();
        indexList.add(1);
        int index = 1;
        int size = 1;
        while (!queue.isEmpty()) {
            size--;
            TreeNode poll = queue.poll();
            index = indexList.removeFirst();
            if (poll.left != null) {
                queue.add(poll.left);
                indexList.add(index * 2);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                indexList.add(index * 2 + 1);
            }
            if (size == 0) {
                if (indexList.size() >= 2) {
                    max = Math.max(indexList.getLast() -indexList.getFirst() + 1, max);
                }
                size = queue.size();
            }

        }

        return max;


    }
    public static void main(String[] args) {
//        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{1,3,2,5,3,null,9});
        TreeNode root = TreeNodeBulider.treeNode(new Integer[]{1,1,1,1,null,null,1,1,null,null,null,null,null,null,1});
        System.out.println(new A662二叉树的最大宽度().widthOfBinaryTree(root));
    }
}
