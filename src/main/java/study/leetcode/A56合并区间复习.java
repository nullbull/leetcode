package study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/3/11 22:22
 * @desc
 */
public class A56合并区间复习 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        List<int[]> ints = Arrays.asList(intervals);
        ints.sort((a, b) -> {
            return a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int t = ints.get(i)[1];
            int j = i + 1;
            while (j < intervals.length && ints.get(j)[0] <= t) {
                t = Math.max(ints.get(j)[1], t);
                j++;
            }
            res.add(new int[]{ints.get(i)[0], t});
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        new A56合并区间复习().merge(new int[][]{{1,4}, {5,6}});
    }
}
