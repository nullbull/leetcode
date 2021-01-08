package study.leetcode;

public class A162寻找峰值 {
    public int findPeakElement(int[] nums) {



        if (nums.length == 2 ) {
            if (nums[0] > nums[1]) {
                return 0;
            }
            return 1;
        }


        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] > nums[i+1]) {
                return i;
            }
        }

        return nums.length-1;

    }

    public static void main(String[] args) {


        int peakElement = new A162寻找峰值().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        System.out.println(peakElement);
    }

}
