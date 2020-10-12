package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2020/10/12 19:27
 * @desc
 */

public class A78子集 {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();



        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                temp.add(nums[j]);
                res.add(new ArrayList<>(temp));
            }
        }
        res.add(new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        new A78子集().subsets(new int[]{1, 2, 3});
    }
}
