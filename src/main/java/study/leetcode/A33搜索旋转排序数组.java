package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/8/11 18:57
 * @desc
 */

public class A33搜索旋转排序数组 {


    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target ) {
                    right =  mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

//        if (nums.length >= 3) {
//            int left = 0;
//            int right = nums.length - 1;
//            int mid;
//
//            int change = 0;
//            while (left <= right) {
//                mid = (right+ left) / 2;
//                if (mid == 0) {
//                    change = 1;
//                    break;
//                }
//                if (mid < nums.length - 1) {
//                    if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
//                        change = mid;
//                        break;
//                    }
//                } else {
//                        change = mid;
//                        break;
//                 }
//                if (nums[left] < nums[mid]) {
//                    left = mid + 1;
//                    continue;
//                }
//                if (nums[left] > nums[mid]) {
//                    right = mid - 1;
//                }
//            }
//
//            if (nums[change] == target) {
//                return change;
//            }
//            left = 0;
//            right = change - 1;
//            while (left <= right) {
//                mid = (left + right) / 2;
//                if (nums[mid] == target) {
//                    return mid;
//                } else if (nums[mid] > target) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }
//
//            left = change + 1;
//            right = nums.length - 1;
//            while (left <= right) {
//                mid = (left + right) / 2;
//                if (nums[mid] == target) {
//                    return mid;
//                } else if (nums[mid] > target) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }
//        } else {
//          for (int i = 0; i < nums.length; i++) {
//              if (nums[i] == target) {
//                  return i;
//              }
//          }
//        }
//
//
//
//        return -1;


    public static void main(String[] args) {
        System.out.println(new A33搜索旋转排序数组().search(new int[]{ 4, 5, 6, 7, 0, 1, 2}, 0));
    }



}
