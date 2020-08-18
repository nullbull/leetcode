package leetcode;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class A39组合总和2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        if (candidates == null) {
            return new ArrayList<>(res);
        }
        dfs(candidates, 0, target, new Stack<Integer>(), res);
        return new ArrayList<>(res);
    }

    public void dfs(int[] candidates, int cur, int target, Stack<Integer> stack, HashSet<List<Integer>> res) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<>(stack);
            temp.sort(Integer::compareTo);
            res.add(temp);
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                stack.add(candidates[i]);
                dfs(candidates, i + 1, target - candidates[i], stack, res);
                stack.pop();
            }

        }
    }



    public static void main(String[] args) {
        System.out.println(new A39组合总和2().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));

    }
}
