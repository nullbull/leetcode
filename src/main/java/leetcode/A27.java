package leetcode;

/**
 * @author niuzhenhao
 * @date 2020/7/29 19:42
 * @desc
 */

public class A27 {
    public int removeElement(int[] nums, int val) {
            int ans = 0;
            for(int num: nums) {
                if(num != val) {
                    nums[ans] = num;
                    ans++;
                }
            }
            return ans;
        }


//        if (nums == null) {
//            return 0;
//        }
//        if (nums.length == 1 && val == nums[0]) {
//            return 0;
//        }
//
//
//        int j = 0;
//        for (int i = 0; i < nums.length;) {
//            int start  = i;
//            if (nums[i] == val) {
//                while (i < nums.length && nums[i] == val ) {
//                    j++;
//                    i++;
//                }
//                for (int k = start; k < nums.length - j ; k++) {
//                    if (nums[k + j] != val) {
//                        nums[k] = nums[k + j];
//                    }
//                }
//
//            } else {
//                i++;
//            }
//
//        }
//       return nums.length - j;


    public static void main(String[] args) {
        System.out.println(new A27().removeElement(new int[]{0,4,4,0,4,4,4,0,2}, 4));
    }
}
