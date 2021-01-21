package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/21 23:01
 * @desc ac
 */
public class A287寻找重复数 {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int cur = nums[i];

            if (cur < 0) {
                i++;
                continue;
            }
            if (nums[cur-1] == -cur) {
                return cur;
            }

            if (nums[cur-1] == cur) {
                nums[cur-1] = -cur;
                i++;
            } else {
                int temp = nums[cur-1];
                nums[cur-1] = -cur;
                nums[i] = temp;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int duplicate = new A287寻找重复数().findDuplicate(new int[]{1,2, 2});
        System.out.println(duplicate);
    }
}
