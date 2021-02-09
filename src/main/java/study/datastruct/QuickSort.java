package study.datastruct;

/**
 * @author niuzhenhao
 * @date 2021/2/9 20:18
 * @desc
 */
public class QuickSort {

    public static void quickSort(int[] nums, int begin, int end) {
        if (begin > end) {
            return;
        }
        int i = begin;
        int j = end;
        int n = nums.length;
        int cur = nums[i];
        while (i < n &&i != j) {
            while (j > i &&nums[j] >= cur) {
                j--;
            }
            while (j > i && nums[i] <= cur) {
                i++;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[begin] = nums[i];
        nums[i] = cur;
        quickSort(nums, begin, i - 1);
        quickSort(nums, i + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 7,0, 12, 9, 18};
        quickSort(nums,0, 5);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
