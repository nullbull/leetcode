package study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author niuzhenhao
 * @date 2021/2/27 17:40
 * @desc
 */
public class A18四数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        if (nums.length == 4) {
            int sum = Arrays.stream(nums).sum();
            if (sum == target) {
                res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
                return res;
            }
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j-1] == nums[j]) {
                    continue;
                }

                int a = nums[i];
                int b = nums[j];
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int sum = a + b + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(a, b, nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r-1]) {
                           r--;
                        }
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new A18四数之和().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
