package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class A39组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates == null) {
            return res;
        }
        dfs(target, 0, new Stack<Integer>(),  candidates, res);
        return res;
    }

    private void dfs(int target, int index, Stack<Integer> pre, int[] candidates, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                pre.push(candidates[i]);
                dfs(target - candidates[i], i, pre, candidates, res);
                Integer pop = pre.pop();
                System.out.println( "---" + pop);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new A39组合总和().combinationSum(new int[]{2, 3, 5}, 8));
    }
}
