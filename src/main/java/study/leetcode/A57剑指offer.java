package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2020/11/13 18:34
 * @desc
 */

public class A57剑指offer {

    public int[][] findContinuousSequence(int target) {
        List<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= target / 2 ; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int now = i;
            int sum = 0;
            while (sum < target) {
                temp.add(now);
                sum += now++;
            }
            if (sum == target) {
                result.add(new ArrayList<>(temp));
            }
        }
        int[][] res = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            Object[] objects = result.get(i).toArray();
            res[i] = new int[objects.length];
            for (int j = 0; j < objects.length; j++) {
                res[i][j] = (int) objects[j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new A57剑指offer().findContinuousSequence(15));
    }
}
