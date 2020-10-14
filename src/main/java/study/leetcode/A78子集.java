package study.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author niuzhenhao
 * @date 2020/10/12 19:27
 * @desc
 */

public class A78子集 {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }
        digui(nums, res, new Stack<>(), 0);
        return res;
    }

    void digui(int[] nums, List<List<Integer>> res, Stack<Integer> path, int now) {
        res.add(new ArrayList<>(path));
        for (int i = now; i < nums.length; i++) {
            path.add(nums[i]);
//            res.add(new ArrayList<>(path));
            digui(nums, res, path, i + 1);
            path.pop();
        }
    }

    public static void main(String[] args) {
        new A78子集().subsets(new int[]{1, 2, 3});
    }
}
