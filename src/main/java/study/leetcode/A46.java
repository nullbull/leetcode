package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2020/8/25 18:51
 * @desc
 */

public class A46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer> > res = new ArrayList<>();

        if (nums == null) {
            return res;
        }
        boolean[] has = new boolean[nums.length];

        traceBack(nums, nums.length, 0 , has, res, new ArrayList<>());

        return res;
    }

    private void traceBack(int[] nums, int now, int dep, boolean[] has, List<List<Integer>> res, List<Integer> temp) {
        if (dep == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < now; i++) {
            if (has[i]) {
                continue;
            }
            has[i] = true;
            temp.add(nums[i]);
            traceBack(nums, now, dep + 1, has, res, temp);
            has[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        new A46().permute(new int[]{1, 2, 3});
    }
}
