package study.datastruct;

/**
 * @author niuzhenhao
 * @date 2020/12/16 10:02
 * @desc
 */

public class Top2 {

    public static void main(String[] args) {
        int[] nums = new int[] {9 ,7 ,4, 6, 3, 8, 11, 25, 18, 86, 90, 77, 64, 55, 29, 38};
        int length = nums.length;
        int p = 1;
        while (p < length) {
            for (int i = 0; i < length;) {
                if (nums[i] < nums[i + p]) {
                    for (int j = i; j < i + p; j++) {
                        swap(j, j + p, nums);
                    }
                }
                i += p * 2;
            }
            System.out.println("p" + p);
            p *= 2;
        }
        System.out.println(nums[0]);
        int second = -1;
        for (int i = 1; i < length; i++) {
            second = Math.max(second, nums[i]);
        }
        System.out.println(second);
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
