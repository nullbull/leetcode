package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/1/7 10:17
 * @desc
 */

public class A560和为K的子数组 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> ttt(int[] nums, int k) {

        dg(nums, k, 0, 0, new ArrayList<Integer>());

        return res;
    }
    public void dg(int[] nums, int k, int p, int sum, List<Integer> list) {
        if (sum == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        } else if (p == nums.length - 1) {
            return;
        } else if (sum > k) {
            return;
        }

        List<Integer> temp = new ArrayList<>();
        for (int i = p; i < nums.length; i++) {
            temp.add(nums[i]);
            if (sum + nums[i] <= k) {
                dg(nums, k, p+1, sum + nums[i], temp);
            } else {
                list.addAll(temp);
//                list.add(nums[i]);
                continue;
            }
            list.addAll(temp);

        }
    }

    public int subarraySum(int[] nums, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = k;
            for (int j = i; j < nums.length; j++) {
                temp -= nums[j];
                if (temp == 0) {
                    count++;
                }
            }
        }
        return count;
    }





    public static void main(String[] args) {
        new A560和为K的子数组().ttt(new int[]{2, 3, 4, 1}, 5);
//        new EEE().subarraySum(new int[]{2, 3, 4, 1}, 5);
//        new EEE().subarraySum(new int[]{1,-1,0}, 0);
//        new EEE().ttt(new int[]{1, 2, 3, 4}, 2);
    }
}
