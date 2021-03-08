package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/3/6 22:54
 * @desc
 */
public class A剑指offer57II和为s的连续正数序列 {

    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;

        List<int[]> res = new ArrayList<>();
        while (i < j) {
            if (s == target) {
                int[] t = new int[j-i+1];
                int cur = 0;
                for (int k = i; k <= j; k++) {
                    t[cur++] = k;
                }
                res.add(t);
            }
            if (s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }

        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        new A剑指offer57II和为s的连续正数序列().findContinuousSequence(15);
    }


}
