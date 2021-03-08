package study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/3/7 17:44
 * @desc
 */
public class A435无重叠区间 {


    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        List<int[]> list = Arrays.asList(intervals);
        list.sort((a, b) ->{
            int al = a[1];
            int bl = b[1];
            return al - bl;
        });
        int ans = 1;
        int n = list.size();
        int end = list.get(0)[1];
        for (int i = 1; i < n; i++) {
            if (end <= list.get(i)[0]) {
                ans++;
                end = list.get(i)[1];
            }
        }
        return n - ans;

    }
}
