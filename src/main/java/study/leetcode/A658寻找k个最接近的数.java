package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/1/7 14:52
 * @desc
 */

public class A658寻找k个最接近的数 {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int m = 0;
        int n = nums.length-1;

        List<Integer> res = new ArrayList<>();
        if (nums[0] > x) {
            for (int i = 0; i < k; i++) {
                res.add(nums[i]);
            }
        }
        if (nums[nums.length-1] < x ) {
            for (int i = nums.length-1; i >= 0 && k > 0; i--,k--) {
                res.add(nums[i]);
            }
            res.sort(Integer::compareTo);
        }
        if (!res.isEmpty()) {
            return res;
        }

        int mid = (m+n) / 2;
        while (m <= n) {
            if (nums[mid] == x) {
                break;
            } else if (nums[mid] < x) {
                m = mid + 1;
            } else {
                n = mid - 1;
            }
            mid = (m+n) / 2;
        }
        int i = mid, j = mid;
        while (k > 0) {
            k--;
            if (i >= 0 && j+1< nums.length) {
                int a = nums[i];
                int b = nums[j+1];
                if (Math.abs(a-x) <= Math.abs(b-x)) {
                    res.add(nums[i]);
                    i--;
                } else {
                    res.add(nums[j+1]);
                    j++;
                }
            } else if (i <= 0 && j+1 < nums.length) {
                res.add(nums[j+1]);
                j++;
            }else if (i >=0 && j == nums.length - 1 ) {
                res.add(nums[i]);
                i--;
            }

        }
        res.sort(Integer::compareTo);
        return res;
    }

    public static void main(String[] args) {

//        System.out.println(new EEE().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3 ));
//        System.out.println(new EEE().findClosestElements(new int[]{1}, 1, 1 ));
//        System.out.println(new EEE().findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9 ));
        System.out.println(new A658寻找k个最接近的数().findClosestElements(new int[]{0,1,1,1,2,3,6,7,8,9}, 9, 4 ));
    }

}
