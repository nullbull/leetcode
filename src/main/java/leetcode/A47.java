package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class A47 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer> > res = new ArrayList<>();

        if (nums == null) {
            return res;
        }
        boolean[] has = new boolean[nums.length];

        HashSet<List<Integer>> set = new HashSet<>();
        traceBack(nums, nums.length, 0 , has, set, new ArrayList<>());

        return new ArrayList<>(set);
    }

    private void traceBack(int[] nums, int now, int dep, boolean[] has, HashSet<List<Integer>> res, List<Integer> temp) {
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
        new A47().permute(new int[]{1, 2, 1});
    }

}
