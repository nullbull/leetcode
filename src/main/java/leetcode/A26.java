package leetcode;

/**
 * @author niuzhenhao
 * @date 2020/7/28 19:10
 * @desc
 */

public class A26 {
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                count ++;
            }
        }
        int time = count;
        for (int i = 0; i < nums.length - 1;) {
            if (nums[i] == nums[i + 1]) {
                if (--time < 0) {
                    break;
                }
                int start = i;
                while (i < nums.length - 1 && nums[i] == nums[++i]) { }
                int l = i - start - 1;
                for (int j = start + 1; (j + l) < nums.length; j++) {
                    nums[j] = nums[j + l];
                }
                i = start;
            } else {
                i ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}
