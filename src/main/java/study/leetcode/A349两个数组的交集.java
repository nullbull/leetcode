package study.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/1/9 9:49
 * @desc
 */

public class A349两个数组的交集 {

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return null;
        }



        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }
        int[] ints = res.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }
}
