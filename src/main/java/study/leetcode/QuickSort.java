package study.leetcode;

import javax.swing.plaf.BorderUIResource;

/**
 * @author niuzhenhao
 * @date 2021/2/7 19:02
 * @desc
 */
public class QuickSort {

    public void quickSort(int[] nums, int begin, int end) {
        int n = nums.length;
        int i = begin;
        int j = end;
        int cur = nums[begin];
        while (i < j ) {
            while (j > i && nums[j] >= cur) {
                j--;
            }
            while (j > i &&  nums[i] <= cur) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i];
        nums[i] = cur;
        nums[begin] = temp;
        quickSort(nums, begin, i - 1);
        quickSort(nums, i + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7 , 6 , 9 ,10, 12, 6, 5 , 11};
        new QuickSort().quickSort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.printf(i + " ");
        }
    }
}
