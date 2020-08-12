package leetcode;

public class A34查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;

        int start = -1;
        int end = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                int temp = mid;
                while(temp >= 0 && nums[temp] == target) {
                    temp--;
                }
                start = temp + 1;
                temp = mid;
                while (temp <= nums.length - 1 && nums[temp] == target) {
                    temp ++;
                }
                end = temp - 1;
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }

        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        System.out.println(new A34查找元素的第一个和最后一个位置().searchRange(new int[]{5, 6, 7, 7, 8, 9}, 4));
    }
}
