package study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author niuzhenhao
 * @date 2020/11/5 19:03
 * @desc
 */

public class A136只出现一次的数组 {
    public int singleNumber(int[] nums) {


        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(collect);

        for (int i = 0; i < collect.size() - 1; i++) {
            if (!collect.get(i).equals(collect.get(i + 1))) {
                if (i == 0 || (i > 0 && !collect.get(i).equals(collect.get(i - 1)))) {
                    return collect.get(i);
                }
            }
        }

        return collect.get(collect.size() - 1);

    }

    public static void main(String[] args) {
        new A136只出现一次的数组().singleNumber(new int[]{4, 1, 2, 1, 2});
    }

}
