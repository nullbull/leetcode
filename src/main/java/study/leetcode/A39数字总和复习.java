package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/2/7 11:10
 * @desc
 */
public class A39数字总和复习 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, int target, List<Integer> list, int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                list.add(nums[i]);

                dfs(nums, target-nums[i], list, i );
                list.remove(list.size()-1);

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new A39数字总和复习().combinationSum(new int[]{2,3,6,7}, 7));
    }

}
