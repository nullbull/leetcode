package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/26 20:37
 * @desc
 */
public class A108数组转平衡二叉树 {


    public TreeNode sortedArrayToBST(int[] nums) {


        if (nums == null || nums.length == 0 ){
            return null;
        }

        TreeNode dg = dg(nums, 0, nums.length - 1);

        return dg;
    }

    public TreeNode dg(int[] nums, int left, int right) {

        if (right - left < 0) {
            return null;
        }
        if (right - left == 2) {
            TreeNode mid = new TreeNode(nums[left + 1]);
            TreeNode rightT = new TreeNode(nums[right]);
            TreeNode leftT = new TreeNode(nums[left]);
            mid.right = rightT;
            mid.left = leftT;
            return mid;
        }
        if (right - left == 1) {
            TreeNode mid = new TreeNode(nums[right]);
            mid.left = new TreeNode(nums[left]);
            return mid;
        }
        if (right == left) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftT = dg(nums, left,mid - 1);
        TreeNode rightT = dg(nums, mid + 1, right);
        root.left = leftT;
        root.right = rightT;
        return root;

    }

    public static void main(String[] args) {

//        TreeNode treeNode = new A108数组转平衡二叉树().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        TreeNode treeNode = new A108数组转平衡二叉树().sortedArrayToBST(new int[]{0,1,2,3,4,5,6,7});
//        TreeNode treeNode = new A108数组转平衡二叉树().sortedArrayToBST(new int[]{0});

    }

}
